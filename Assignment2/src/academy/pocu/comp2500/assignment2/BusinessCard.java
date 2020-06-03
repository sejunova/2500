package academy.pocu.comp2500.assignment2;

public class BusinessCard extends Product{
    private BusinessCardType businessCardType;
    private int price;
    private Color color;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;
    private TextAperture textAperture = new TextAperture();
    private ImageAperture imageAperture = new ImageAperture();
    private Orientation orientation;
    private BusinessCardSides businessCardSides;

    public BusinessCard(BusinessCardType businessCardType, Color color, BusinessCardSides businessCardSides, Orientation orientation) {
        super(90, 50);
        this.color = color;
        this.orientation = orientation;
        this.businessCardSides = businessCardSides;
        this.businessCardType = businessCardType;
        switch (businessCardType) {
            case LINEN:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 110;
                    case DOUBLE_SIDE:
                        this.price = 140;
                    default:
                        throw new RuntimeException("wrong enum BusinessCardSides val");
                }
            case LAID:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 120;
                    case DOUBLE_SIDE:
                        this.price = 150;
                    default:
                        throw new RuntimeException("wrong enum BusinessCardSides val");
                }
            case SMOOTH:
                switch (businessCardSides) {
                    case SINGLE_SIDE:
                        this.price = 100;
                    case DOUBLE_SIDE:
                        this.price = 130;
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

    public Color getColor() {
        return color;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
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
