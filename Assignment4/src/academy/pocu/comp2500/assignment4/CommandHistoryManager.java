package academy.pocu.comp2500.assignment4;

import java.util.Stack;

public class CommandHistoryManager {
    private Canvas canvas;
    private Stack<ICommand> commandStack = new Stack<>();
    private Stack<ICommand> undoStack = new Stack<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            this.commandStack.add(command);
            this.undoStack.clear();
            return true;
        }
        return false;
    }

    public boolean canUndo() {
        return !this.commandStack.isEmpty();
    }

    public boolean canRedo() {
        return !this.undoStack.isEmpty();
    }

    public boolean undo() {
        if (this.commandStack.isEmpty()) {
            return false;
        }
        boolean isExecuted = this.commandStack.peek().undo();
        this.undoStack.add(this.commandStack.pop());
        return isExecuted;
    }

    public boolean redo() {
        if (this.undoStack.isEmpty()) {
            return false;
        }
        boolean isExecuted = this.undoStack.peek().redo();
        this.commandStack.add(this.undoStack.pop());
        return isExecuted;
    }

}
