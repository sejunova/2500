package academy.pocu.comp2500.assignment4;

public class ClearCommand implements ICommand{
    @Override
    public boolean execute(Canvas canvas) {

        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }

    @Override
    public boolean redo() {
        return false;
    }
}
