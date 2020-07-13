package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        Canvas canvas = new Canvas(10, 5);
//        canvas.drawPixel(1, 2, 'b');
        canvas.drawPixel(1, 2, '\u0000');

        System.out.println(canvas.getDrawing());
    }
}
