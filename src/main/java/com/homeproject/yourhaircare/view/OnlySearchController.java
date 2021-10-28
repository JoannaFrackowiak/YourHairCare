package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.service.*;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.dto.CosmeticToShowDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import com.homeproject.yourhaircare.service.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OnlySearchController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CosmeticService cosmeticService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private SiliconService siliconService;

    @GetMapping("/search-for-user")
    public ModelAndView chooseCosmetic2(@RequestParam(name = "brandName", required = false) String brandName,
                                        @RequestParam(name = "typeName", required = false) String typeName,
                                        @RequestParam(name = "cosmeticName", required = false) String cosmeticName,
                                        Authentication authentication) throws NotFound {
        String loggedUserEmail = authentication.getName();
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("email", loggedUserEmail);
//        BrandDto brandDto1 = brandService.getOneBrand(brandName);
//        TypeDto typeDto = typeService.getOneType(typeName);
//        CosmeticDto cosmeticDto = cosmeticService.getCosmetic(cosmeticName, brandDto1.getId(), typeDto.getId());


        if (brandName == null || brandName.isEmpty()) {
            modelAndView = new ModelAndView("search-for-user-brand");
            modelAndView.addObject("email", loggedUserEmail);
            List<BrandDto> brandDtoList = brandService.getAllBrands();
            modelAndView.addObject("brands", brandDtoList);
            return modelAndView;
        } else if (typeName != null && cosmeticName == null) {
//            BrandDto brandDto1 = brandService.getOneBrand(brandName);
//            TypeDto typeDto = typeService.getOneType(typeName);

            modelAndView = new ModelAndView("search-for-user-cosmetic");
            modelAndView.addObject("email", loggedUserEmail);
            modelAndView.addObject("selectedBrand", brandName);
            modelAndView.addObject("selectedType", typeName);

            List<CosmeticToShowDto> cosmeticDtoList = cosmeticService.getAllCosmeticsToShow(brandName, typeName);
            modelAndView.addObject("cosmetics", cosmeticDtoList);
            return modelAndView;
        } else if (cosmeticName != null) {
//            BrandDto brandDto1 = brandService.getOneBrand(brandName);
//            TypeDto typeDto = typeService.getOneType(typeName);
            CosmeticToShowDto cosmeticDto = cosmeticService.getCosmeticToShow(cosmeticName, brandName, typeName);
            modelAndView = new ModelAndView("search-for-user-allData");
            modelAndView.addObject("email", loggedUserEmail);
//            modelAndView.addObject("selectedBrand", brandName);
//            modelAndView.addObject("selectedType", typeName);
//            modelAndView.addObject("selectedCosmetic", cosmeticName);
            modelAndView.addObject("cosmeticData", cosmeticDto);
//            modelAndView.addObject("feature", featureService.getFeature(cosmeticDto.getFeatureId()).getName());
//            modelAndView.addObject("silicons", siliconService.getAllSiliconForCosmetic(cosmeticDto.getId()));
            return modelAndView;
        } else {
            modelAndView = new ModelAndView();
            modelAndView = new ModelAndView("search-for-user-type");
            modelAndView.addObject("email", loggedUserEmail);
            modelAndView.addObject("selectedBrand", brandName);
            List<TypeDto> typeDtoList = typeService.getAllTypes();
            modelAndView.addObject("types", typeDtoList);
            return modelAndView;

        }
    }
}



//    @GetMapping("/search-for-user")
//    public ModelAndView chooseCosmetic3(@RequestParam(name = "brandName") String brandName,
////                                       @RequestParam(name = "typeName", required = false) String typeName,
//                                        Authentication authentication) {
//        String loggedUserEmail = authentication.getName();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView = new ModelAndView("search-for-user-type");
//        modelAndView.addObject("email", loggedUserEmail);
//        modelAndView.addObject("selectedBrand", brandName);
//        List<TypeDto> typeDtoList = typeService.getAllTypes();
//        modelAndView.addObject("types", typeDtoList);
//        return modelAndView;
//
//    }
//
//    @GetMapping("/search-for-user")
//    public ModelAndView chooseCosmetic1(@RequestParam(name = "brandName") String brandName,
//                                        @RequestParam(name = "typeName") String typeName,
////                @RequestParam(name = "cosmeticName", required = false) String cosmeticName,
//                                        Authentication authentication) {
//        String loggedUserEmail = authentication.getName();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView = new ModelAndView("search-for-user-cosmetic");
//        modelAndView.addObject("email", loggedUserEmail);
//        modelAndView.addObject("selectedBrand", brandName);
//        modelAndView.addObject("selectedType", typeName);
//        BrandDto brandDto1 = brandService.getOneBrand(brandName);
//        TypeDto typeDto = typeService.getOneType(typeName);
//        List<CosmeticDto> cosmeticDtoList = cosmeticService.getAllCosmetics(brandDto1.getId(), typeDto.getId());
//        modelAndView.addObject("cosmetics", cosmeticDtoList);
//        return modelAndView;
//    }


