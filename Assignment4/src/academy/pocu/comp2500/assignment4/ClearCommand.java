package academy.pocu.comp2500.assignment4;

public class ClearCommand implements ICommand {
    private char[][] beforeClear;
    private Canvas canvas;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
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
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }

    @Override
    public boolean undo() {
        if (!this.commandStatus.equals(CommandStatus.UNDOABLE)) {
            return false;
        }
        for (int i = 0; i < this.canvas.getHeight(); i++) {
            for (int j = 0; j < this.canvas.getWidth(); j++) {
                this.canvas.drawPixel(j, i, this.beforeClear[i][j]);
            }
        }
        this.commandStatus = CommandStatus.REDOABLE;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.commandStatus.equals(CommandStatus.REDOABLE)) {
            return false;
        }
        this.canvas.clear();
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }
}
