package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public IncreasePixelCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.canvas = canvas;
        boolean isExecuted = canvas.increasePixel(this.x, this.y);
        this.canUndo = isExecuted;
        return isExecuted;
    }

    @Override
    public boolean undo() {
        if (!this.canUndo) {
            return false;
        }
        this.canvas.decreasePixel(this.x, this.y);
        this.canUndo = false;
        this.canRedo = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.canRedo) {
            return false;
        }
        this.canvas.increasePixel(this.x, this.y);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
