package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private char[] beforeVertical;
    private Canvas canvas;
    private char pixel;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public FillVerticalLineCommand(int x, char pixel) {
        this.x = x;
        this.pixel = pixel;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.beforeVertical = new char[canvas.getHeight()];
        for (int i = 0; i < canvas.getHeight(); i++) {
            this.beforeVertical[i] = canvas.getPixel(this.x, i);
        }
        canvas.fillVerticalLine(this.x, this.pixel);
        this.canvas = canvas;
        this.canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.canUndo) {
            return false;
        }
        for (int i = 0; i < this.canvas.getHeight(); i++) {
            this.canvas.drawPixel(this.x, i, this.beforeVertical[i]);
        }
        this.canUndo = false;
        this.canRedo = true;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.canRedo) {
            return false;
        }
        this.canvas.fillVerticalLine(this.x, this.pixel);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }

}
