package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.*;
import com.homeproject.yourhaircare.service.dto.*;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyCosmeticsController {

    @Autowired
    private CosmeticService cosmeticService;
    @Autowired
    private UserCosmeticService userCosmeticService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandService brandService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private ShoppingListCosmeticService shoppingListCosmeticService;

//    @GetMapping("/my-cosmetics")
//    public ModelAndView cosmeticsForUser(Authentication authentication) {
//        String loggedUserEmail = authentication.getName();
//        List<CosmeticDto> cosmeticDtoList = cosmeticService.getAllCosmeticsForUser2(loggedUserEmail);
//        List<BrandDto> brandDtoList = brandService.getAllBrandsForUser(loggedUserEmail);
////        List<TypeDto> typeDtoList = typeService.getAllTypesForUser(cosmeticDtoList);
////        List<FeatureDto> featureDtoList = featureService.getAllFeaturesForUser(cosmeticDtoList);
//        ModelAndView modelAndView = new ModelAndView("my-cosmetics");
//        modelAndView.addObject("login", loggedUserEmail);
//        modelAndView.addObject("cosmetic", cosmeticDtoList);
//        modelAndView.addObject("brand", brandDtoList);
////        modelAndView.addObject("type", typeDtoList);
////        modelAndView.addObject("feature", featureDtoList);
//        return modelAndView;
//    }
//
//    @PostMapping("/brand")
//    public ModelAndView addNewUser(@ModelAttribute Long brandId) throws BadRequest, AlreadyExists {
//        ModelAndView modelAndView = new ModelAndView("my-cosmetics");
//        BrandDto brandDto = brandService.getOneBrand(brandId);
//        modelAndView.addObject("nameBrand", brandDto);
//        return modelAndView;
//    }

    @GetMapping("/my-cosmetics")
    public ModelAndView cosmeticsForUser(Authentication authentication) {
        String loggedUserEmail = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("my-cosmetics");
        modelAndView.addObject("login", loggedUserEmail);
        List<CosmeticToShowDto> cosmeticDtoList = cosmeticService.getAllCosmeticsForUserTest(loggedUserEmail);
        modelAndView.addObject("cosmetics", cosmeticDtoList);
//        List<BrandDto> brandDtoList = brandService.getAllBrandsForUser(loggedUserEmail);

//        List<FeatureDto> featureDtoList = featureService.getAllFeaturesForUser(cosmeticDtoList);

//        modelAndView.addObject("feature", featureDtoList);
        return modelAndView;
    }

    @GetMapping("/deleteCosmeticUser")
    public String deleteCosmeticUser(@RequestParam(name = "fromWhere", required = false) String fromWhere,
                                     @RequestParam(name = "id") Long id,
                                     Authentication authentication) throws NotFound, BadRequest {
        String loggedUserEmail = authentication.getName();
        if (fromWhere != null && fromWhere.equals("shoppingList")) {
            shoppingListCosmeticService.deleteCosmeticShopppingList(id, loggedUserEmail);
            return "redirect:/shopping-list";
        } else {
            userCosmeticService.deleteCosmeticUser(id, loggedUserEmail);
            return "redirect:/my-cosmetics";
        }
    }

//    @GetMapping("/add-cosmetic-to-list")
//    public ModelAndView addCosmeticToList(Authentication authentication) {
//        String loggedUserEmail = authentication.getName();
//        ModelAndView modelAndView = new ModelAndView("add-cosmetic-to-user-list");
//        List<BrandDto> brandDtoList = brandService.getAllBrands();
//        List<TypeDto> typeDtoList = typeService.getAllTypes();
//        modelAndView.addObject("brands", brandDtoList);
//        modelAndView.addObject("types", typeDtoList);
//        return modelAndView;
//    }

    @GetMapping("/add-user-cosmetic")
    public ModelAndView chooseCosmetic2(@RequestParam(name = "brandName", required = false) String brandName,
                                        @RequestParam(name = "typeName", required = false) String typeName,
                                        @RequestParam(name = "cosmeticName", required = false) String cosmeticName,
                                        @RequestParam(name = "action", required = false) String action,
                                        Authentication authentication) throws NotFound, BadRequest {
        ModelAndView modelAndView = new ModelAndView();
        if (brandName == null) {
            modelAndView = new ModelAndView("add-cosmetic-to-user-list");
            List<BrandDto> brandDtoList = brandService.getAllBrands();
            List<TypeDto> typeDtoList = typeService.getAllTypes();
            modelAndView.addObject("brands", brandDtoList);
            modelAndView.addObject("types", typeDtoList);
            return modelAndView;
        } else
        if (cosmeticName == null) {
//            BrandDto brandDto1 = brandService.getOneBrand(brandName);
//            TypeDto typeDto = typeService.getOneType(typeName);
//            List<CosmeticDto> cosmeticDtoList = cosmeticService.getAllCosmetics(brandDto1.getId(), typeDto.getId());
            List<CosmeticToShowDto> cosmeticDtoList = cosmeticService.getAllCosmeticsToShow(brandName, typeName);
            modelAndView = new ModelAndView("add-name-cosmetic-to-list");
            modelAndView.addObject("selectedBrand", brandName);
            modelAndView.addObject("selectedType", typeName);
            modelAndView.addObject("cosmetics", cosmeticDtoList);
            return modelAndView;
        } else {
            String loggedUserEmail = authentication.getName();
//            BrandDto brandDto1 = brandService.getOneBrand(brandName);
//            TypeDto typeDto = typeService.getOneType(typeName);
            CosmeticDto cosmeticDto = cosmeticService.getCosmetic(cosmeticName, brandName, typeName);
            if (action.equals("Dodaj do listy swoich kosmetyków")) {
                try {
                    userCosmeticService.addCosmeticToUser(cosmeticDto.getId(), loggedUserEmail);
                } catch (AlreadyExists alreadyExists) {
                    return new ModelAndView("redirect:/exist-cosmetic");
                }
                return new ModelAndView("redirect:/my-cosmetics");
            } else {
                try {
                    shoppingListCosmeticService.addCosmeticToShoppingList(cosmeticDto.getId(), loggedUserEmail);
                } catch (AlreadyExists alreadyExists) {
                    return new ModelAndView("redirect:/exist-cosmetic?shoppingList");
                }
                return new ModelAndView("redirect:/shopping-list");
            }
        }
    }

    @GetMapping("/exist-cosmetic")
    public ModelAndView existCosmetic(@RequestParam(name = "shoppingList", required = false) String shoppingList) {
        ModelAndView modelAndView = new ModelAndView("exist-cosmetic");
        if (shoppingList != null) {
            modelAndView.addObject("shoppingList", true);
        }
        return modelAndView;
    }

    @GetMapping("/shopping-list")
    public ModelAndView shoppingList(Authentication authentication) {
        String loggedUserEmail = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("shopping-list");
        modelAndView.addObject("login", loggedUserEmail);
        List<CosmeticToShowDto> cosmeticDtoList = cosmeticService.getAllCosmeticsFromShoppingList(loggedUserEmail);
        modelAndView.addObject("cosmetics", cosmeticDtoList);
        return modelAndView;
    }


//    @GetMapping("/add-user-cosmetic")
//    public ModelAndView chooseCosmetic2(@RequestParam(name = "brandName", required = false) String brandName,
//                                        @RequestParam(name = "typeName", required = false) String typeName,
//                                        @RequestParam(name = "cosmeticName", required = false) String cosmeticName,
//                                        Authentication authentication) throws NotFound, AlreadyExists, BadRequest {
//        BrandDto brandDto1 = brandService.getOneBrand(brandName);
//        TypeDto typeDto = typeService.getOneType(typeName);
//        if (cosmeticName == null) {
//            List<CosmeticDto> cosmeticDtoList = cosmeticService.getAllCosmetics(brandDto1.getId(), typeDto.getId());
//            ModelAndView modelAndView = new ModelAndView("add-name-cosmetic-to-list");
//            modelAndView.addObject("cosmetics", cosmeticDtoList);
//            return modelAndView;
//        } else {
//            String loggedUserEmail = authentication.getName();
//            CosmeticDto cosmeticDto = cosmeticService.getCosmetic(cosmeticName, brandDto1.getId(), typeDto.getId());
//            userCosmeticService.addCosmeticToUser(cosmeticDto.getId(), loggedUserEmail);
//            ModelAndView modelAndView = new ModelAndView("/my-cosmetics");
//            modelAndView.addObject("login", loggedUserEmail);
////
//            return modelAndView;
////        }
//        }
//        ModelAndView modelAndView = new ModelAndView("my-cosmetics");
//        return modelAndView;

}


