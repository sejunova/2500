package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("Paper", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("Paper", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("Paper", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("Paper", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("Paper", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("Paper", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("Paper", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("Paper", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("Paper", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("Paper", "addImageAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("Paper", "addImageAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("Paper", "addTextAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("Paper", "addImageAperture");
    }
}
