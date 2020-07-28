package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    public DecreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
            return false;
        }
        this.canvas = canvas;
        boolean isExecuted = canvas.decreasePixel(this.x, this.y);
        this.commandStatus = (isExecuted) ? CommandStatus.UNDOABLE : CommandStatus.FAILED;
        return isExecuted;
    }

    @Override
    public boolean undo() {
        if (!this.commandStatus.equals(CommandStatus.UNDOABLE)) {
            return false;
        }
        this.canvas.increasePixel(this.x, this.y);
        this.commandStatus = CommandStatus.REDOABLE;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.commandStatus.equals(CommandStatus.REDOABLE)) {
            return false;
        }
        this.canvas.decreasePixel(this.x, this.y);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }
}
