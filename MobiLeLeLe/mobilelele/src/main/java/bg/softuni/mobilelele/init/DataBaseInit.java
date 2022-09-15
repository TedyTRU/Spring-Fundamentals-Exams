package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;

    public DataBaseInit(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initBrands();
        modelService.initModels();
    }
}
