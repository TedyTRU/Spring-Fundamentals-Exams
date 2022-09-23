package bg.softuni.mobilelele.model.dto.offer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SearchOfferDto {

    private String model;
    private Integer minPrice;
    private Integer maxPrice;

    @NotBlank
    public String getModel() {
        return model;
    }

    public SearchOfferDto setModel(String model) {
        this.model = model;
        return this;
    }

    @NotNull
    public Integer getMinPrice() {
        return minPrice;
    }

    public SearchOfferDto setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    @NotNull
    public Integer getMaxPrice() {
        return maxPrice;
    }

    public SearchOfferDto setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public boolean isEmpty() {
        return (model == null || model.isEmpty()) &&
                minPrice == null &&
                maxPrice == null;
    }
}
