package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        //스탬프(잉크: 빨강)	4 x 3 cm	2300
        //5 x 2 cm	2300
        //7 x 4 cm	2600
        //스탬프(잉크: 파랑)	4 x 3 cm	2300
        //5 x 2 cm	2300
        //7 x 4 cm	2600
        //스탬프(잉크: 녹색)	4 x 3 cm	2300
        //5 x 2 cm	2300
        //7 x 4 cm	2600

        Stamp redStamp4_3 = new Stamp(StampColor.RED, StampSize.WIDTH_40_HEIGHT_30, "xx");
        assert redStamp4_3.getPrice() == 2300;
        Stamp redStamp5_2 = new Stamp(StampColor.RED, StampSize.WIDTH_50_HEIGHT_20, "xx");
        assert redStamp5_2.getPrice() == 2300;
        Stamp redStamp7_4 = new Stamp(StampColor.RED, StampSize.WIDTH_70_HEIGHT_40, "xx");
        assert redStamp7_4.getPrice() == 2600;

        Stamp blueStamp4_3 = new Stamp(StampColor.BLUE, StampSize.WIDTH_40_HEIGHT_30, "xx");
        assert blueStamp4_3.getPrice() == 2300;
        Stamp blueStamp5_2 = new Stamp(StampColor.BLUE, StampSize.WIDTH_50_HEIGHT_20, "xx");
        assert blueStamp5_2.getPrice() == 2300;
        Stamp blueStamp7_4 = new Stamp(StampColor.BLUE, StampSize.WIDTH_70_HEIGHT_40, "xx");
        assert blueStamp7_4.getPrice() == 2600;

        Stamp greenStamp4_3 = new Stamp(StampColor.GREEN, StampSize.WIDTH_40_HEIGHT_30, "xx");
        assert greenStamp4_3.getPrice() == 2300;
        Stamp greenStamp5_2 = new Stamp(StampColor.GREEN, StampSize.WIDTH_50_HEIGHT_20, "xx");
        assert greenStamp5_2.getPrice() == 2300;
        Stamp greenStamp7_4 = new Stamp(StampColor.GREEN, StampSize.WIDTH_70_HEIGHT_40, "xx");
        assert greenStamp7_4.getPrice() == 2600;


        //벽걸이(Wall) 달력	40 x 40 cm	흰색	1000
        //탁상(Desk) 달력	20 x 15 cm	흰색	1000
        //자석(Magnet) 달력	10 x 20 cm	흰색	1500

        Calendar wallCalendar = new Calendar(CalendarType.WALL_CALENDAR);
        assert wallCalendar.getPrice() == 1000;
        Calendar deskCalendar = new Calendar(CalendarType.DESK_CALENDAR);
        assert deskCalendar.getPrice() == 1000;
        Calendar magnetCalendar = new Calendar(CalendarType.MAGNET_CALENDAR);
        assert magnetCalendar.getPrice() == 1500;

        Cart cart = new Cart();
        cart.addProduct(redStamp4_3);
        cart.addProduct(redStamp5_2);
        cart.addProduct(redStamp7_4);
        cart.addProduct(blueStamp4_3);
        cart.addProduct(blueStamp5_2);
        cart.addProduct(blueStamp7_4);
        cart.addProduct(greenStamp4_3);
        cart.addProduct(greenStamp5_2);
        cart.addProduct(greenStamp7_4);
        cart.addProduct(wallCalendar);
        cart.addProduct(deskCalendar);
        cart.addProduct(magnetCalendar);
        cart.removeProduct(redStamp4_3);
        assert cart.getTotalPrice() == 25100 - 2300;

        //반사(Gloss) 배너	1 x 0.5 m	5000
        //1 x 1 m	5200
        //2 x 0.5 m	5300
        //3 x 1 m	6000
        //스크림(Scrim) 배너	1 x 0.5 m	5100
        //1 x 1 m	5300
        //2 x 0.5 m	5400
        //3 x 1 m	6100
        //메쉬(Mesh) 배너	1 x 0.5 m	5100
        //1 x 1 m	5300
        //2 x 0.5 m	5400
        //3 x 1 m	6100

        Banner glossBanner1000_500 = new Banner(BannerType.GLOSS, BannerSize.WIDTH_1000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert glossBanner1000_500.getPrice() == 5000;
        Banner glossBanner1000_1000 = new Banner(BannerType.GLOSS, BannerSize.WIDTH_1000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert glossBanner1000_1000.getPrice() == 5200;
        Banner glossBanner2000_500 = new Banner(BannerType.GLOSS, BannerSize.WIDTH_2000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert glossBanner2000_500.getPrice() == 5300;
        Banner glossBanner3000_1000 = new Banner(BannerType.GLOSS, BannerSize.WIDTH_3000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert glossBanner3000_1000.getPrice() == 6000;

        Banner scrimBanner1000_500 = new Banner(BannerType.SCRIM, BannerSize.WIDTH_1000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert scrimBanner1000_500.getPrice() == 5100;
        Banner scrimBanner1000_1000 = new Banner(BannerType.SCRIM, BannerSize.WIDTH_1000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert scrimBanner1000_1000.getPrice() == 5300;
        Banner scrimBanner2000_500 = new Banner(BannerType.SCRIM, BannerSize.WIDTH_2000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert scrimBanner2000_500.getPrice() == 5400;
        Banner scrimBanner3000_1000 = new Banner(BannerType.SCRIM, BannerSize.WIDTH_3000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert scrimBanner3000_1000.getPrice() == 6100;

        Banner meshBanner1000_500 = new Banner(BannerType.MESH, BannerSize.WIDTH_1000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert meshBanner1000_500.getPrice() == 5100;
        Banner meshBanner1000_1000 = new Banner(BannerType.MESH, BannerSize.WIDTH_1000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert meshBanner1000_1000.getPrice() == 5300;
        Banner meshBanner2000_500 = new Banner(BannerType.MESH, BannerSize.WIDTH_2000_HEIGHT_500, 0xFFFFFF, Orientation.LANDSCAPE);
        assert meshBanner2000_500.getPrice() == 5400;
        Banner meshBanner3000_1000 = new Banner(BannerType.MESH, BannerSize.WIDTH_3000_HEIGHT_1000, 0xFFFFFF, Orientation.LANDSCAPE);
        assert meshBanner3000_1000.getPrice() == 6100;

        //린넨커버(Linen) 명함	단면	110
        //양면	140
        //레이드지(Laid) 명함	단면	120
        //양면	150
        //스노우지(Smooth) 명함	단면	100
        //양면	130

        BusinessCard linenSingle = new BusinessCard(BusinessCardType.LINEN, BusinessCardColor.GREY, BusinessCardSides.SINGLE_SIDE, Orientation.LANDSCAPE);
        assert linenSingle.getPrice() == 110;
        BusinessCard linenDouble = new BusinessCard(BusinessCardType.LINEN, BusinessCardColor.GREY, BusinessCardSides.DOUBLE_SIDE, Orientation.LANDSCAPE);
        assert linenDouble.getPrice() == 140;

        BusinessCard laidSingle = new BusinessCard(BusinessCardType.LAID, BusinessCardColor.GREY, BusinessCardSides.SINGLE_SIDE, Orientation.LANDSCAPE);
        assert laidSingle.getPrice() == 120;
        BusinessCard laidDouble = new BusinessCard(BusinessCardType.LAID, BusinessCardColor.GREY, BusinessCardSides.DOUBLE_SIDE, Orientation.LANDSCAPE);
        assert laidDouble.getPrice() == 150;

        BusinessCard smoothSingle = new BusinessCard(BusinessCardType.SMOOTH, BusinessCardColor.GREY, BusinessCardSides.SINGLE_SIDE, Orientation.LANDSCAPE);
        assert smoothSingle.getPrice() == 100;
        BusinessCard smoothDouble = new BusinessCard(BusinessCardType.SMOOTH, BusinessCardColor.GREY, BusinessCardSides.DOUBLE_SIDE, Orientation.LANDSCAPE);
        assert smoothDouble.getPrice() == 130;
    }
}
