package academy.pocu.comp2500.assignment4;

public class DecreasePixelCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private char beforeExecute;
    private boolean canRedo = false;

    public DecreasePixelCommand(int x, int y) {
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
        return canvas.decreasePixel(this.x, this.y);
    }

    @Override
    public boolean undo() {
        if (this.canvas == null) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == beforeExecute) {
            return false;
        }
        this.canvas.increasePixel(this.x, this.y);
        this.canRedo = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (this.canvas == null) {
            return false;
        }
        if (!this.canRedo) {
            return false;
        }
        this.canvas.decreasePixel(this.x, this.y);
        this.canRedo = false;
        return true;
    }
}
