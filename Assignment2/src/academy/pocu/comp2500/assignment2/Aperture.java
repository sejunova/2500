package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class Aperture {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    Aperture(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
