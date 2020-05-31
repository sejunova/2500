package academy.pocu.comp2500.assignment2;

public class Banner {
    private BannerType bannerType;
    private int width;
    private int height;
    private int price;
    private String color;
    private DeliveryMethod deliveryMethod = DeliveryMethod.PICKUP;
    private TextAperture textAperture = new TextAperture();
    private ImageAperture imageAperture = new ImageAperture();
    private Orientation orientation;

    public Banner(BannerType bannerType, int width, int height, String color, Orientation orientation) {
        if (width == 1000 && height == 500) {
            switch (bannerType) {
                case GLOSS:
                    this.price = 5000;
                    break;
                case SCRIM:
                case MESH:
                    this.price = 5100;
                    break;
                default:
                    throw new RuntimeException("Wrong bannerType");
            }
        } else if (width == 1000 && height == 1000) {
            switch (bannerType) {
                case GLOSS:
                    this.price = 5200;
                    break;
                case SCRIM:
                case MESH:
                    this.price = 5300;
                    break;
                default:
                    throw new RuntimeException("Wrong bannerType");
            }
        } else if (width == 2000 && height == 500) {
            switch (bannerType) {
                case GLOSS:
                    this.price = 5300;
                    break;
                case SCRIM:
                case MESH:
                    this.price = 5400;
                    break;
                default:
                    throw new RuntimeException("Wrong bannerType");
            }
        } else if (width == 3000 && height == 1000) {
            switch (bannerType) {
                case GLOSS:
                    this.price = 6000;
                    break;
                case SCRIM:
                case MESH:
                    this.price = 6100;
                    break;
                default:
                    throw new RuntimeException("Wrong bannerType");
            }
        } else {
            throw new RuntimeException("Wrong width and height given");
        }
        this.width = width;
        this.height = height;
        this.color = color;
        this.bannerType = bannerType;
        this.orientation = orientation;
    }

    public BannerType getBannerType() {
        return bannerType;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
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

    public void addTextAperture(String text) {
        this.textAperture.addAperture(text);
    }

    public void addImageAperture(String image) {
        this.imageAperture.addAperture(image);
    }
}
