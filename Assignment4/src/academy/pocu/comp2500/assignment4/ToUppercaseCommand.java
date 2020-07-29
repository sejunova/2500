package academy.pocu.comp2500.assignment4;

public class ToUppercaseCommand implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private char beforeExecute;
    private char afterExecute;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public ToUppercaseCommand(int x, int y) {
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
        canvas.toUpper(this.x, this.y);
        this.afterExecute = canvas.getPixel(this.x, this.y);
        this.canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.canvas == null) {
            return false;
        }
        if (!this.canUndo) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) != this.afterExecute) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == this.beforeExecute) {
            return false;
        }
        this.canvas.drawPixel(this.x, this.y, this.beforeExecute);
        this.canUndo = false;
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
        if (this.canvas.getPixel(this.x, this.y) != this.beforeExecute) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == this.afterExecute) {
            return false;
        }

        this.canvas.toUpper(this.x, this.y);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
