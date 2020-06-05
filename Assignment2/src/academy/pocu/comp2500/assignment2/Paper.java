package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class Paper extends Product{
    protected List<TextAperture> textApertures = new ArrayList<>();
    protected List<ImageAperture> imageApertures = new ArrayList<>();
    protected Orientation orientation;

    Paper(int width, int height, Orientation orientation) {
        super(width, height);
        this.orientation = orientation;
    }

    public List<TextAperture> getTextApertures() {
        return this.textApertures;
    }

    public List<ImageAperture> getImageApertures() {
        return this.imageApertures;
    }

    public void addTextAperture(TextAperture textAperture) {
        if (textAperture.getX() + textAperture.getWidth() > super.width) {
            return;
        }
        if (textAperture.getY() + textAperture.getHeight() > super.height) {
            return;
        }

        this.textApertures.add(textAperture);
        super.price += 5;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        if (imageAperture.getX() + imageAperture.getWidth() > super.width) {
            return;
        }
        if (imageAperture.getY() + imageAperture.getHeight() > super.height) {
            return;
        }
        this.imageApertures.add(imageAperture);
        super.price += 5;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
