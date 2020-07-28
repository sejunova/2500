package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char c;
    private Canvas canvas;
    private char beforeExecute;
    private boolean canRedo = false;

    public DrawPixelCommand(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.canvas = canvas;
        this.beforeExecute = canvas.getPixel(this.x, this.y);
        canvas.drawPixel(this.x, this.y, this.c);
        return true;
    }

    @Override
    public boolean undo() {
        if (this.canvas == null) {
            return false;
        }
        if (this.canvas.getPixel(this.x, this.y) == beforeExecute) {
            return false;
        }
        this.canvas.drawPixel(this.x, this.y, this.beforeExecute);
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
        this.canvas.drawPixel(this.x, this.y, this.c);
        this.canRedo = false;
        return true;
    }
}
