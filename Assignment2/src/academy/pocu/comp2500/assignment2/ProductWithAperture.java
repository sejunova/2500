package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class ProductWithAperture extends Product{
    protected List<TextAperture> textApertures = new ArrayList<>();
    protected List<ImageAperture> imageApertures = new ArrayList<>();
    protected Orientation orientation;

    ProductWithAperture(int width, int height, Orientation orientation) {
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
        this.textApertures.add(textAperture);
        if (textAperture.getText() == null) {
            return;
        }
        if (textAperture.getWidth() <= 0 || textAperture.getHeight() <= 0) {
            return;
        }
        if (!(0 <= textAperture.getX() && textAperture.getX() < super.width)) {
            return;
        }
        if (!(0 <= textAperture.getY() && textAperture.getY() < super.height)) {
            return;
        }

        if (textAperture.getX() + textAperture.getWidth() > super.width) {
            return;
        }

        if (textAperture.getY() + textAperture.getHeight() > super.height) {
            return;
        }
        super.price += 5;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        this.imageApertures.add(imageAperture);
        if (imageAperture.getImage() == null) {
            return;
        }
        if (imageAperture.getWidth() <= 0 || imageAperture.getHeight() <= 0) {
            return;
        }
        if (!(0 <= imageAperture.getX() && imageAperture.getX() < super.width)) {
            return;
        }
        if (!(0 <= imageAperture.getY() && imageAperture.getY() < super.height)) {
            return;
        }

        if (imageAperture.getX() + imageAperture.getWidth() > super.width) {
            return;
        }

        if (imageAperture.getY() + imageAperture.getHeight() > super.height) {
            return;
        }

        super.price += 5;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
