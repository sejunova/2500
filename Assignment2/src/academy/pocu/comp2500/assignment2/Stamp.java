package academy.pocu.comp2500.assignment2;

public class Stamp extends Product{
    private StampColor color;
    private String text;

    public Stamp(StampColor color, int width, int height, String text) {
        super(width, height);

        if (width == 40 && height == 30) {
            this.price = 2300;
        } else if (width == 50 && height == 20) {
            this.price = 2300;
        } else if (width == 70 && height == 40) {
            this.price = 2600;
        } else {
            throw new RuntimeException("Wrong width & height given");
        }
        this.color = color;
        this.text = text;
    }

    public String getColor() {
        return color.getColor();
    }

    public String getText() {
        return text;
    }
}
