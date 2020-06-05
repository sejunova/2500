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
        registry.registerLandscapeBannerTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ProductWithAperture", "addTextAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ProductWithAperture", "addImageAperture");
    }
}
