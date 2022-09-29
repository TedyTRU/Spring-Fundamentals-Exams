package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.offer.AddOfferDto;
import bg.softuni.mobilelele.model.dto.offer.SearchOfferDto;
import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.OfferService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allOffers(Model model,
                            @PageableDefault(sort = "price",
                                    direction = Sort.Direction.ASC,
                                    page = 0, size = 3) Pageable pageable) {

        model.addAttribute("offers", offerService.getAllOffers(pageable));

        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {

        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDto());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);

            return "redirect:add";
        }

        offerService.adOffer(addOfferModel, userDetails);

        return "redirect:all";
    }

//    @GetMapping("/search")
//    public String search(Model model) {
//
//        if (!model.containsAttribute("searchOfferModel")) {
//            model.addAttribute("searchOfferModel", new SearchOfferDto());
//        }
//
//        return "offer-search";
//    }

//    @PostMapping("/search")
//    public String searchQuery(@Valid SearchOfferDto searchOfferDto,
//                              BindingResult bindingResult,
//                              RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("searchOfferModel", searchOfferDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.searchOfferModel", bindingResult);
//
//            return "redirect:search";
//        }
//
//        if (!searchOfferDto.isEmpty()) {
//            redirectAttributes.addFlashAttribute("offers", offerService.searchOffer(searchOfferDto));
//
//            return "redirect:search";
//        }
//
//        return "redirect:search";
//    }

    @GetMapping("/search")
    public String search(SearchOfferDto searchOfferDto,
                         Model model) {

        if (!model.containsAttribute("searchOfferModel")) {
            model.addAttribute("searchOfferModel", searchOfferDto);
        }

        if (!searchOfferDto.isEmpty()) {
            model.addAttribute("offers", offerService.searchOffer(searchOfferDto));
        }

        return "offer-search";
    }

    @GetMapping("/{id}/details")
    public String getOfferDetail(@PathVariable("id") Long id,
                                 Model model) {

        var offer = offerService.getOfferDetails(id)
                .orElseThrow();

        model.addAttribute("offer", offer);

        return "details";
    }

}
