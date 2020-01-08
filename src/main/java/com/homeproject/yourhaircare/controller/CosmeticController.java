package com.homeproject.yourhaircare.controller;

import com.homeproject.yourhaircare.service.CosmeticService;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cosmetic")
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping
    public List<CosmeticDto> getAllCosmetics(@RequestParam(required = false) String name) {
        return cosmeticService.getAllCosmetics();
    }

    @GetMapping("/{id}")
    public CosmeticDto getCosmetic(@PathVariable Long id) throws NotFound {
        return cosmeticService.getCosmetic(id);
    }

    @PostMapping()
    public CosmeticDto addNewCosmetic(@RequestBody CreateAndChangeCosmeticDto createCosmeticDto)
            throws BadRequest, AlreadyExists {
        return cosmeticService.addNewCosmetic(createCosmeticDto);
    }

//    @PutMapping("/{id}")
//    public CosmeticDto updateCosmetic(@RequestBody CreateAndChangeCosmeticDto changeCosmeticDto, @PathVariable Long id)
//            throws AlreadyExists, NotFound {
//        return cosmeticService.updateCosmetic(changeCosmeticDto, id);
//    }

    @DeleteMapping("/{id}")
    public CosmeticDto deleteCosmetic(@PathVariable Long id) throws NotFound {
        return cosmeticService.deleteCosmetic(id);
    }
}
