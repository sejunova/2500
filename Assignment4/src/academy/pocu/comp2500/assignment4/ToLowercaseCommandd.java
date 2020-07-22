package academy.pocu.comp2500.assignment4;

public class ToLowercaseCommandd implements ICommand {
    private int x;
    private int y;
    private Canvas canvas;
    private char existingPixel;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public ToLowercaseCommandd(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.canvas = canvas;
        this.existingPixel = canvas.getPixel(this.x, this.y);
        canvas.toLower(this.x, this.y);
        this.canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.canUndo) {
            return false;
        }
        this.canvas.drawPixel(this.x, this.y, this.existingPixel);
        this.canUndo = false;
        this.canRedo = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.canRedo) {
            return false;
        }
        this.canvas.toLower(this.x, this.y);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
