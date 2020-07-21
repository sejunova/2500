package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.ClearCommand;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.FillHorizontalLineCommand;
import academy.pocu.comp2500.assignment4.FillVerticalLineCommand;

public class Program {

    public static void main(String[] args) {
        {
            // write your code here
            Canvas canvas = new Canvas(10, 5);

            CommandHistoryManager manager = new CommandHistoryManager(canvas);
            manager.execute(new DrawPixelCommand(1, 1, 'a'));
            manager.execute(new DrawPixelCommand(2, 2, 'a'));
            manager.execute(new DrawPixelCommand(3, 3, 'a'));
            System.out.println(manager.canUndo()); // true
            System.out.println(manager.canRedo()); // false
            System.out.println("-------------");

            manager.undo();

            System.out.println(manager.canUndo()); // true
            System.out.println(manager.canRedo()); // true
            System.out.println("-------------");

            manager.redo();
            System.out.println(manager.canUndo()); // true
            System.out.println(manager.canRedo()); // false;
            System.out.println("-------------");

            manager.undo();

            System.out.println(manager.canUndo()); // true
            System.out.println(manager.canRedo()); // true
            System.out.println("-------------");

            manager.undo();

            System.out.println(manager.canUndo()); // true
            System.out.println(manager.canRedo()); // true
            System.out.println("-------------");

            manager.undo();

            System.out.println(manager.canUndo()); // false
            System.out.println(manager.canRedo()); // true
            System.out.println("-------------");
        }
        {
            Canvas canvas = new Canvas(10, 5);

            CommandHistoryManager manager = new CommandHistoryManager(canvas);
            manager.execute(new DrawPixelCommand(1, 1, 'a'));
            manager.execute(new DrawPixelCommand(2, 3, 'a'));
            manager.execute(new ClearCommand());
            assert (canvas.getPixel(1,1) == ' ');
            assert (canvas.getPixel(2,3) == ' ');
            manager.undo();
            assert (canvas.getPixel(1,1) == 'a');
            assert (canvas.getPixel(2,3) == 'a');
            manager.redo();
            assert (canvas.getPixel(1,1) == ' ');
            assert (canvas.getPixel(2,3) == ' ');
        }
        {
            Canvas canvas = new Canvas(10, 5);

            CommandHistoryManager manager = new CommandHistoryManager(canvas);
            manager.execute(new DrawPixelCommand(1, 2, 'a'));
            manager.execute(new DrawPixelCommand(2, 2, 'a'));
            manager.execute(new FillHorizontalLineCommand(2, 'x'));
            assert (canvas.getPixel(1,2) == 'x');
            assert (canvas.getPixel(2,2) == 'x');
            manager.undo();
            assert (canvas.getPixel(1,2) == 'a');
            assert (canvas.getPixel(2,2) == 'a');
            manager.redo();
            assert (canvas.getPixel(1,2) == 'x');
            assert (canvas.getPixel(2,2) == 'x');
        }

        {
            Canvas canvas = new Canvas(10, 5);

            CommandHistoryManager manager = new CommandHistoryManager(canvas);
            manager.execute(new DrawPixelCommand(2, 1, 'a'));
            manager.execute(new DrawPixelCommand(2, 2, 'a'));
            manager.execute(new FillVerticalLineCommand(2, 'x'));
            assert (canvas.getPixel(2,1) == 'x');
            assert (canvas.getPixel(2,2) == 'x');
            manager.undo();
            assert (canvas.getPixel(2,1) == 'a');
            assert (canvas.getPixel(2,2) == 'a');
            manager.redo();
            assert (canvas.getPixel(2,1) == 'x');
            assert (canvas.getPixel(2,2) == 'x');
        }
    }
}
