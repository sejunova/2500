package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char[] beforeHorizon;
    private Canvas canvas;
    private char c;
    private boolean canUndo = false;
    private boolean canRedo = false;

    public FillHorizontalLineCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.beforeHorizon = new char[canvas.getWidth()];
        for (int i = 0; i < canvas.getWidth(); i++) {
            this.beforeHorizon[i] = canvas.getPixel(i, this.y);
        }
        canvas.fillHorizontalLine(this.y, this.c);
        this.canvas = canvas;
        this.canUndo = true;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.canUndo) {
            return false;
        }
        for (int i = 0; i < this.canvas.getWidth(); i++) {
            this.canvas.drawPixel(i, this.y, this.beforeHorizon[i]);
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
        this.canvas.fillHorizontalLine(this.y, this.c);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
