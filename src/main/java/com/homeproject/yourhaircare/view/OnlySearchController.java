package com.homeproject.yourhaircare.view;

import com.homeproject.yourhaircare.service.BrandService;
import com.homeproject.yourhaircare.service.CosmeticService;
import com.homeproject.yourhaircare.service.TypeService;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/search-for-user")
    public ModelAndView chooseCosmetic(Authentication authentication) {
        String loggedUserEmail = authentication.getName();


        ModelAndView modelAndView = new ModelAndView("search-for-user");
        CosmeticDto cosmeticDto = new CosmeticDto();
        BrandDto brandDto = new BrandDto();
//        List<BrandDto> brandDtoList = brandService.getAllBrands();
        List<BrandDto> brandDtoList = brandService.getAllBrandsForUser(loggedUserEmail);
        List<TypeDto> typeDtoList = typeService.getAllTypes();
        List<CosmeticDto> cosmeticDtoList = cosmeticService.getAllCosmetics();
        modelAndView.addObject("brand", brandDto);
        modelAndView.addObject("brands", brandDtoList);
        modelAndView.addObject("email", loggedUserEmail);
        modelAndView.addObject("types", typeDtoList);
        modelAndView.addObject("nameCosmetic", cosmeticDtoList);
        return modelAndView;
    }



}
