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
        registry.registerLandscapeBannerTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerGlossBannerTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerGlossBannerImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerScrimBannerTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerScrimBannerImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerMeshBannerTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerMeshBannerImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ProductWithAperture", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ProductWithAperture", "addAperture");
    }
}
