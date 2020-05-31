package academy.pocu.comp2500.assignment2;

public enum Color {
    RED("#FF0000"),
    BLUE("#0000FF"),
    GREEN("#008000"),
    GREY("#E6E6E6"),
    IVORY("#FFFFF0"),
    WHITE("#FFFFFF");

    private String color;

    private Color(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return this.color;
    }
}

