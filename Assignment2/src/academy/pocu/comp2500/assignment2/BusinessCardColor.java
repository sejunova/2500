package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GREY(0xE6E6E6),
    IVORY(0xFFFFF0),
    WHITE(0xFFFFFF);

    private int color;

    BusinessCardColor(int color)
    {
        this.color = color;
    }

    public int getColor()
    {
        return this.color;
    }

    public static BusinessCardColor[] all() {
        return values();
    }
}

