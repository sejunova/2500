package academy.pocu.comp2500.assignment4;

public interface ICommand {
    public boolean execute(Canvas canvas);

    public boolean undo();

    public boolean redo();
}
