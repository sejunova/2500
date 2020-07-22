package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private char[] beforeVertical;
    private Canvas canvas;
    private char c;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
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
        canvas.fillVerticalLine(this.x, this.c);
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
        this.canvas.fillVerticalLine(this.x, this.c);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }

}
