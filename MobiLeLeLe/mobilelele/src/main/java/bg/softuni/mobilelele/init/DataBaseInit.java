package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;

    public DataBaseInit(BrandService brandService, ModelService modelService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initBrands();
        modelService.initModels();
        offerService.initOffers();
    }
}
