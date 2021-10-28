package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.service.*;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.dto.CreateUpdateNewProductDto;
import com.homeproject.yourhaircare.service.dto.FeatureDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AddCosmeticController {

    @Autowired
    private NewProductsService newProductsService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping("/form-add-cosmetic")
    public ModelAndView addCosmetic(Authentication authentication) {
        String loggedUserEmail = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("form-add-cosmetic");
        CreateUpdateNewProductDto createUpdateNewProductsListDto = new CreateUpdateNewProductDto();
        List<BrandDto> brandDtoList = brandService.getAllBrands();
        List<TypeDto> typeDtoList = typeService.getAllTypes();
        List<FeatureDto> featureDtoList = featureService.getAllFeatures();
        modelAndView.addObject("form", createUpdateNewProductsListDto);
        modelAndView.addObject("login", loggedUserEmail);
        modelAndView.addObject("brands", brandDtoList);
        modelAndView.addObject("types", typeDtoList);
        modelAndView.addObject("features", featureDtoList);
        return modelAndView;
    }


    @PostMapping("/add-cosmetic")
    public String addNewProduct(@ModelAttribute CreateUpdateNewProductDto createUpdateNewProductDto) throws BadRequest {
        newProductsService.createNewProduct(createUpdateNewProductDto);
        return "redirect:/thanks";
    }


}
