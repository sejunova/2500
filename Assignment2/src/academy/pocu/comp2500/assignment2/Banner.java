package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banner extends Product {
    private BannerType bannerType;
    private List<TextAperture> textApertures = new ArrayList<>();
    private List<ImageAperture> imageApertures = new ArrayList<>();
    private Orientation orientation;

    public Banner(BannerType type, BannerSize size, String color, Orientation orientation) {
        super(0, 0);
        if (!Arrays.asList(BannerType.all()).contains(type)) {
            throw new RuntimeException("invalid type given");
        }
        if (!Arrays.asList(BannerSize.all()).contains(size)) {
            throw new RuntimeException("invalid size given");
        }

        switch (size) {
            case WIDTH_1000_HEIGHT_500:
                if (type.equals(BannerType.GLOSS)) {
                    super.price = 5000;
                } else {
                    super.price = 5100;
                }
                break;
            case WIDTH_1000_HEIGHT_1000:
                if (type.equals(BannerType.GLOSS)) {
                    super.price = 5200;
                } else {
                    super.price = 5300;
                }
                break;
            case WIDTH_2000_HEIGHT_500:
                if (type.equals(BannerType.GLOSS)) {
                    super.price = 5300;
                } else {
                    super.price = 5400;
                }
                break;
            case WIDTH_3000_HEIGHT_1000:
                if (type.equals(BannerType.GLOSS)) {
                    super.price = 6000;
                } else {
                    super.price = 6100;
                }
                break;
            default:
                break;
        }
        super.width = size.getWidth();
        super.height = size.getHeight();
        super.color = color;
        this.bannerType = type;
        this.orientation = orientation;
    }

    public BannerType getBannerType() {
        return bannerType;
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

    public void addTextAperture(TextAperture textAperture) {
        this.textApertures.add(textAperture);
        super.price += 5;
    }

    public void addImageAperture(ImageAperture imageAperture) {
        this.imageApertures.add(imageAperture);
        super.price += 5;
    }
}
