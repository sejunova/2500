package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char pixel;
    private char existingPixel;
    private Canvas canvas;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public DrawPixelCommand(int x, int y, char pixel) {
        this.x = x;
        this.y = y;
        this.pixel = pixel;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.existingPixel = canvas.getPixel(this.x, this.y);
        canvas.drawPixel(this.x, this.y, this.pixel);
        this.canvas = canvas;
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
        this.canvas.drawPixel(this.x, this.y, this.pixel);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
