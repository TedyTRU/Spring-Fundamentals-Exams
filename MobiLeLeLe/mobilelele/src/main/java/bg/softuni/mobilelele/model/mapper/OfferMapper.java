package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.model.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    //@Mapping(target = "active", constant = "true")
    Offer addOfferDtoToOfferEntity(AddOfferDto addOfferDto);
}
