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
        registry.registerLandscapeBannerTextApertureAdder("Banner", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("Banner", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("Banner", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("Banner", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("Banner", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("Banner", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("Banner", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("Banner", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("Banner", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("Banner", "addImageAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("BusinessCard", "addImageAperture");
    }
}
