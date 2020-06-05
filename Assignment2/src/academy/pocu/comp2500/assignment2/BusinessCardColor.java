package academy.pocu.comp2500.assignment2;

public enum BusinessCardColor {
    GREY("#E6E6E6"),
    IVORY("#FFFFF0"),
    WHITE("#FFFFFF");

    private String color;

    BusinessCardColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return this.color;
    }

    public static BusinessCardColor[] all() {
        return values();
    }
}

