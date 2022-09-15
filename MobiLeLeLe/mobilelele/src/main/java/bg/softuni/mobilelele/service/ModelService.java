package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.enums.CategoryEnum;
import bg.softuni.mobilelele.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelService(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    public void initModels() {
        if (modelRepository.count() != 0) {
            return;
        }

        List<Model> models = new ArrayList<>();

        models.add(new Model()
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1976)
                .setEndYear(null)
                .setName("Fiesta")
                .setBrand(brandService.findBrandByName("Ford"))
                .setImageUrl("https://static.motor.es/fotos-noticias/2021/11/precio-ford-fiesta-2022-202183060-1638099043_1.jpg"));
        models.add(new Model()
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1999)
                .setEndYear(null)
                .setName("Yaris")
                .setBrand(brandService.findBrandByName("Toyota"))
                .setImageUrl("https://www.motortrend.com/uploads/sites/10/2015/11/2014-toyota-yaris-le-3-door-hatchback-angular-front.png"));
        models.add(new Model()
                .setCategory(CategoryEnum.CAR)
                .setStartYear(2012)
                .setEndYear(null)
                .setName("Sportage")
                .setBrand(brandService.findBrandByName("Kia"))
                .setImageUrl("https://hips.hearstapps.com/hmg-prod/images/18050-2023-sportage-x-pro-1635358262.jpg?crop=0.697xw:0.784xh;0.204xw,0.0721xh&resize=640:*"));
        models.add(new Model()
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1968)
                .setEndYear(2000)
                .setName("Escort")
                .setBrand(brandService.findBrandByName("Ford"))
                .setImageUrl("https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg"));

        modelRepository.saveAll(models);
    }
}
