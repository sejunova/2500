package academy.pocu.comp2500.assignment2;

public class BusinessCard extends Product{
    private BusinessCardType businessCardType;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;
    private TextAperture textAperture = new TextAperture();
    private ImageAperture imageAperture = new ImageAperture();
    private Orientation orientation;
    private BusinessCardSides businessCardSides;

    public BusinessCard(BusinessCardType businessCardType, Color color, BusinessCardSides businessCardSides, Orientation orientation) {
        super(90, 50);
        super.color = color.getColor();
        this.orientation = orientation;
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;
        switch (businessCardType) {
            case LINEN:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 110;
                        break;
                    case DOUBLE_SIDE:
                        this.price = 140;
                        break;
                    default:
                        throw new RuntimeException("wrong enum BusinessCardSides val");
                }
            case LAID:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 120;
                        break;
                    case DOUBLE_SIDE:
                        this.price = 150;
                        break;
                    default:
                        throw new RuntimeException("wrong enum BusinessCardSides val");
                }
            case SMOOTH:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 100;
                        break;
                    case DOUBLE_SIDE:
                        this.price = 130;
                        break;
                    default:
                        throw new RuntimeException("wrong enum BusinessCardSides val");
                }
            default:
                throw new RuntimeException("wrong enum BusinessCardType val");
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
