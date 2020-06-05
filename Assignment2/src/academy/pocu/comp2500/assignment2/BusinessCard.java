package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessCard extends Product{
    private BusinessCardType businessCardType;
    private List<TextAperture> textApertures = new ArrayList<>();
    private List<ImageAperture> imageApertures = new ArrayList<>();
    private Orientation orientation;
    private BusinessCardSides businessCardSides;

    public BusinessCard(BusinessCardType type, BusinessCardColor color, BusinessCardSides sides, Orientation orientation) {
        super(90, 50);
        if (!Arrays.asList(BusinessCardType.all()).contains(type)) {
            throw new RuntimeException("invalid type given");
        }
        if (!Arrays.asList(BusinessCardColor.all()).contains(color)) {
            throw new RuntimeException("invalid color given");
        }

        super.color = color.getColor();
        this.orientation = orientation;
        this.businessCardSides = sides;
        this.businessCardType = type;
        switch (type) {
            case LINEN:
                if (sides.equals(BusinessCardSides.SINGLE_SIDE)) {
                    super.price = 110;
                } else {
                    super.price = 140;
                }
                break;
            case LAID:
                if (sides.equals(BusinessCardSides.SINGLE_SIDE)) {
                    super.price = 120;
                } else {
                    super.price = 150;
                }
                break;
            case SMOOTH:
                if (sides.equals(BusinessCardSides.SINGLE_SIDE)) {
                    super.price = 100;
                } else {
                    super.price = 130;
                }
                break;
            default:
                break;
        }
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public List<TextAperture> getTextApertures() {
        return textApertures;
    }

    public List<ImageAperture> getImageApertures() {
        return imageApertures;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public void addTextAperture(TextAperture textAperture) {
        this.textApertures.add(textAperture);
        super.price += 5;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        this.imageApertures.add(imageAperture);
        super.price += 5;
    }
}
