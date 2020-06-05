package academy.pocu.comp2500.assignment2;

import java.util.Arrays;

public class BusinessCard extends Paper{
    private BusinessCardType businessCardType;
    private BusinessCardSides businessCardSides;

    public BusinessCard(BusinessCardType type, BusinessCardColor color, BusinessCardSides sides, Orientation orientation) {
        super(90, 50, orientation);
        if (!Arrays.asList(BusinessCardType.all()).contains(type)) {
            throw new RuntimeException("invalid type given");
        }
        if (!Arrays.asList(BusinessCardColor.all()).contains(color)) {
            throw new RuntimeException("invalid color given");
        }

        super.color = color.getColor();
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

    public BusinessCardSides getBusinessCardSides() {
        return businessCardSides;
    }
}
