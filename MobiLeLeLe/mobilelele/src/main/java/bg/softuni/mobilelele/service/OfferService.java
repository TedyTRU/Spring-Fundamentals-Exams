package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDto;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.mapper.OfferMapper;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper, UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public void adOffer(AddOfferDto addOfferDto) {

        Offer newOffer = offerMapper
                .addOfferDtoToOfferEntity(addOfferDto);

        // TODO - current user should be logged in

        User seller = userRepository
                .findByEmail(currentUser.getEmail())
                .orElseThrow();

        Model model = modelRepository
                .findById(addOfferDto.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }

    private Offer mapToEntity(AddOfferDto addOfferDto) {

        return null;
    }


}
