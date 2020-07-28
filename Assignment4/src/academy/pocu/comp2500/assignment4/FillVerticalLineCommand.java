package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private char[] beforeExecute;
    private char[] afterExecute;
    private Canvas canvas;
    private char c;

    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.beforeExecute = new char[canvas.getHeight()];
        for (int i = 0; i < canvas.getHeight(); i++) {
            this.beforeExecute[i] = canvas.getPixel(this.x, i);
        }
        canvas.fillVerticalLine(this.x, this.c);
        this.afterExecute = new char[canvas.getHeight()];
        for (int i = 0; i < canvas.getHeight(); i++) {
            this.afterExecute[i] = canvas.getPixel(this.x, i);
        }
        this.canvas = canvas;
        return true;
    }

    @Override
    public boolean undo() {
        if (this.canvas == null) {
            return false;
        }
        boolean canUndo = false;
        for (int i = 0; i < canvas.getHeight(); i++) {
            if (this.beforeExecute[i] != canvas.getPixel(this.x, i)) {
                canUndo = true;
                break;
            }
        }

        if (!canUndo) {
            return false;
        }

        for (int i = 0; i < this.canvas.getHeight(); i++) {
            this.canvas.drawPixel(this.x, i, this.beforeExecute[i]);
        }
        return true;
    }

    @Override
    public boolean redo() {
        if (this.canvas == null) {
            return false;
        }
        boolean canRedo = false;
        for (int i = 0; i < canvas.getHeight(); i++) {
            if (this.afterExecute[i] != canvas.getPixel(this.x, i)) {
                canRedo = true;
                break;
            }
        }

        if (!canRedo) {
            return false;
        }
        this.canvas.fillVerticalLine(this.x, this.c);
        return true;
    }

}
