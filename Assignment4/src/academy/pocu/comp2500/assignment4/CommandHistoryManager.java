package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommandHistoryManager {
    private Canvas canvas;
    private Stack<ICommand> commandStack = new Stack<>();
    private Queue<ICommand> commandQueue = new LinkedList<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            this.commandStack.add(command);
            this.commandQueue.clear();
            return true;
        }
        return false;
    }

    public boolean canUndo() {
        return !this.commandStack.isEmpty();
    }

    public boolean canRedo() {
        return !this.commandQueue.isEmpty();
    }

    public boolean undo() {
        if (this.commandStack.isEmpty()) {
            return false;
        }
        boolean isExecuted = this.commandStack.peek().undo();
        if (isExecuted) {
            this.commandQueue.add(this.commandStack.pop());
        }
        return isExecuted;
    }

    public boolean redo() {
        if (this.commandQueue.isEmpty()) {
            return false;
        }
        boolean isExecuted = this.commandQueue.peek().redo();
        if (isExecuted) {
            this.commandStack.add(this.commandQueue.poll());
        }
        return isExecuted;
    }

}
