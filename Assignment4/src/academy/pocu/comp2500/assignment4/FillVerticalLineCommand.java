package academy.pocu.comp2500.assignment4;

public class FillVerticalLineCommand implements ICommand {
    private int x;
    private char[] beforeVertical;
    private Canvas canvas;
    private char c;
    private CommandStatus commandStatus = CommandStatus.EXECUTABLE;

    public FillVerticalLineCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!this.commandStatus.equals(CommandStatus.EXECUTABLE)) {
            return false;
        }
        this.beforeVertical = new char[canvas.getHeight()];
        for (int i = 0; i < canvas.getHeight(); i++) {
            this.beforeVertical[i] = canvas.getPixel(this.x, i);
        }
        canvas.fillVerticalLine(this.x, this.c);
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
            this.canvas.drawPixel(this.x, i, this.beforeVertical[i]);
        }
        this.commandStatus = CommandStatus.REDOABLE;
        return true;
    }

    @Override
    public boolean redo() {
        if (!this.commandStatus.equals(CommandStatus.REDOABLE)) {
            return false;
        }
        this.canvas.fillVerticalLine(this.x, this.c);
        this.commandStatus = CommandStatus.UNDOABLE;
        return true;
    }

}
