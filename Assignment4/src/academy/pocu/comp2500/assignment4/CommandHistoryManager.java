package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> commands = new ArrayList<>();
    private int curCommandIndex = -1;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            this.commands.add(command);
            return true;
        }
        return false;
    }


}
