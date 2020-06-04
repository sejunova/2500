package academy.pocu.comp2500.assignment2;

import java.util.Arrays;

public class Stamp extends Product{
    private String text;

    public Stamp(StampColor color, StampSize size, String text) {
        super(size.getWidth(), size.getHeight());
        if (!Arrays.asList(StampColor.all()).contains(color)) {
            throw new RuntimeException("invalid color given");
        }
        if (!Arrays.asList(StampSize.all()).contains(size)) {
            throw new RuntimeException("invalid size given");
        }
        super.price = size.getPrice();
        super.color = color.getColor();
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
