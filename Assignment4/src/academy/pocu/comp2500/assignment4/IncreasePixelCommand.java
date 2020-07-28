package academy.pocu.comp2500.assignment4;

public class IncreasePixelCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private char beforeExecute;
    private char afterExecute;

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
        this.beforeExecute = canvas.getPixel(this.x, this.y);
        boolean isExecuted = canvas.increasePixel(this.x, this.y);
        this.afterExecute = canvas.getPixel(this.x, this.y);
        return isExecuted;
    }

    @Override
    public boolean undo() {
        if (this.canvas == null) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == this.beforeExecute) {
            return false;
        }
        this.canvas.decreasePixel(this.x, this.y);
        return true;
    }

    @Override
    public boolean redo() {
        if (this.canvas == null) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == this.afterExecute) {
            return false;
        }
        this.canvas.increasePixel(this.x, this.y);
        return true;
    }
}
