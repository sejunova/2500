package academy.pocu.comp2500.assignment4;

public class ClearCommand implements ICommand {
    private char[][] beforeClear;
    private Canvas canvas;
    private boolean canUndo = false;
    private boolean canRedo = false;

    @Override
    public boolean execute(Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }
        this.beforeClear = new char[canvas.getHeight()][canvas.getWidth()];
        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                this.beforeClear[i][j] = canvas.getPixel(j, i);
            }
        }
        canvas.clear();
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
            for (int j = 0; j < this.canvas.getWidth(); j++) {
                this.canvas.drawPixel(j, i, this.beforeClear[i][j]);
            }
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
        this.canvas.clear();
        this.canUndo = true;
        this.canRedo = false;
        return true;
    }
}
