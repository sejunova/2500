package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private char existingPixel;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    public ToUppercaseCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
            return false;
        }
        this.canvas = canvas;
        this.existingPixel = canvas.getPixel(this.x, this.y);
        canvas.toUpper(this.x, this.y);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.commandStatus.equals(CommandStatus.UNDOABLE)) {
            return false;
        }
        this.canvas.drawPixel(this.x, this.y, this.existingPixel);
        this.commandStatus = CommandStatus.REDOABLE;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.commandStatus.equals(CommandStatus.REDOABLE)) {
            return false;
        }
        this.canvas.toUpper(this.x, this.y);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }
}
