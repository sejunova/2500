package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char[] beforeHorizon;
    private Canvas canvas;
    private char c;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    public FillHorizontalLineCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
            this.commandStatus = CommandStatus.FAILED;
            return false;
        }
        this.beforeHorizon = new char[canvas.getWidth()];
        for (int i = 0; i < canvas.getWidth(); i++) {
            this.beforeHorizon[i] = canvas.getPixel(i, this.y);
        }
        canvas.fillHorizontalLine(this.y, this.c);
        this.canvas = canvas;
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.commandStatus.equals(CommandStatus.UNDOABLE)) {
            return false;
        }
        for (int i = 0; i < this.canvas.getWidth(); i++) {
            this.canvas.drawPixel(i, this.y, this.beforeHorizon[i]);
        }
        this.commandStatus = CommandStatus.REDOABLE;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.commandStatus.equals(CommandStatus.REDOABLE)) {
            return false;
        }
        this.canvas.fillHorizontalLine(this.y, this.c);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }
}
