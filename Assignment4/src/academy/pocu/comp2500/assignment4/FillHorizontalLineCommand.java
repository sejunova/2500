package academy.pocu.comp2500.assignment4;

public class FillHorizontalLineCommand implements ICommand {
    private int y;
    private char[] beforeExecute;
    private char[] afterExecute;
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
        this.beforeExecute = new char[canvas.getWidth()];
        for (int i = 0; i < canvas.getWidth(); i++) {
            this.beforeExecute[i] = canvas.getPixel(i, this.y);
        }
        canvas.fillHorizontalLine(this.y, this.c);
        this.afterExecute = new char[canvas.getWidth()];
        for (int i = 0; i < canvas.getWidth(); i++) {
            this.afterExecute[i] = canvas.getPixel(i, this.y);
        }
        this.canvas = canvas;
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

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (this.afterExecute[i] != canvas.getPixel(i, this.y)) {
                return false;
            }
        }

//        for (int i = 0; i < canvas.getWidth(); i++) {
//            if (this.beforeExecute[i] == canvas.getPixel(i, this.y)) {
//                return false;
//            }
//        }

        for (int i = 0; i < this.canvas.getWidth(); i++) {
            this.canvas.drawPixel(i, this.y, this.beforeExecute[i]);
        }
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

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (this.beforeExecute[i] != canvas.getPixel(i, this.y)) {
                return false;
            }
        }

//        for (int i = 0; i < canvas.getWidth(); i++) {
//            if (this.afterExecute[i] == canvas.getPixel(i, this.y)) {
//                return false;
//            }
//        }

        this.canvas.fillHorizontalLine(this.y, this.c);
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
