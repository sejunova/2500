package academy.pocu.comp2500.assignment2;

import java.util.Arrays;

public class BusinessCard extends Product{
    private BusinessCardType businessCardType;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;
    private TextAperture textAperture = new TextAperture();
    private ImageAperture imageAperture = new ImageAperture();
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

    public TextAperture getTextAperture() {
        return textAperture;
    }

    public ImageAperture getImageAperture() {
        return imageAperture;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }

    public void addTextAperture(String text) {
        this.textAperture.addAperture(text);
    }

    public void addImageAperture(String image) {
        this.imageAperture.addAperture(image);
    }
}
