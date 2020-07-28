package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char c;
    private char existingPixel;
    private Canvas canvas;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
            return false;
        }
        this.existingPixel = canvas.getPixel(this.x, this.y);
        canvas.drawPixel(this.x, this.y, this.c);
        this.canvas = canvas;
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
        this.canvas.drawPixel(this.x, this.y, this.c);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }
}
