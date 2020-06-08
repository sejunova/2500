package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED(0xFF0000),
    BLUE(0x0000FF),
    GREEN(0x008000);

    private int color;

    StampColor(int color)
    {
        this.color = color;
    }

    public int getColor()
    {
        return this.color;
    }

    public static StampColor[] all() {
        return values();
    }
}
