package academy.pocu.comp2500.assignment2;

public class Stamp extends Product{
    private String text;

    public Stamp(StampColor color, StampSize size, String text) {
        super(size.getWidth(), size.getHeight());
        super.price = size.getPrice();
        super.color = color.getColor();
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
