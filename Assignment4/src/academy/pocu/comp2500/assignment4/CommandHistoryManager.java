package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> commands = new ArrayList<>();
    private int curCommandIndex;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            if (this.commands.size() - 1 != this.curCommandIndex) {
                this.commands.subList(this.curCommandIndex, this.commands.size()).clear();
            }
            this.commands.add(command);
            this.curCommandIndex = this.commands.size() - 1;
            return true;
        }
        return false;
    }

    public boolean canUndo() {
        return 0 <= curCommandIndex && curCommandIndex < this.commands.size();
    }

    public boolean canRedo() {
        return -1 <= curCommandIndex && curCommandIndex < this.commands.size() - 1;
    }

    public boolean undo() {
        boolean isExecuted = this.commands.get(this.curCommandIndex).undo();
        if (isExecuted) {
            this.curCommandIndex--;
        }
        return isExecuted;
    }

    public boolean redo() {
        boolean isExecuted = this.commands.get(this.curCommandIndex + 1).redo();
        if (isExecuted) {
            this.curCommandIndex++;
        }
        return isExecuted;
    }

}
