package academy.pocu.comp2500.assignment2;

public enum StampColor {
    RED("#FF0000"),
    BLUE("#0000FF"),
    GREEN("#008000");

    private String color;

    StampColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return this.color;
    }

    public static StampColor[] all() {
        return values();
    }
}