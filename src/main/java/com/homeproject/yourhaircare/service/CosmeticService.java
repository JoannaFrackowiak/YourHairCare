package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.repository.CosmeticRepository;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.exception.NotFound;
import com.homeproject.yourhaircare.service.mapper.CosmeticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository cosmeticRepository;
    @Autowired
    private CosmeticMapper cosmeticMapper;

    @Transactional
    public List<CosmeticDto> getAllCosmetics() {
//        if (brand != null) {
//            cosmeticRepository.findAllByBrand(brand)
//                    .stream()
//                    .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
//                    .collect(Collectors.toList());
//        }
        return cosmeticRepository.findAll()
                .stream()
                .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public CosmeticDto getCosmetic(@PathVariable Long id) throws NotFound {
        return cosmeticRepository.findById(id)
                .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                .orElseThrow(NotFound::new);

    }

    @Transactional
    public CosmeticDto addNewCosmetic(@RequestBody CreateAndChangeCosmeticDto createCosmeticDto)
            throws BadRequest, AlreadyExists {
        Cosmetic existCosmetic = cosmeticRepository.findCosmeticByBrandAndNameAndType(createCosmeticDto.getBrandId(),
                createCosmeticDto.getName(), createCosmeticDto.getTypeId());
        if (createCosmeticDto.getName() == null) {
            throw new BadRequest();
        } else if (existCosmetic == null) {
            existCosmetic = cosmeticRepository.save(cosmeticMapper.fromDto(createCosmeticDto));
            return cosmeticMapper.toDto(existCosmetic);
        } else {
            throw new AlreadyExists();
        }
    }

//    @Transactional
//    public CosmeticDto updateCosmetic(@RequestBody CreateAndChangeCosmeticDto changeCosmeticDto, @PathVariable Long id)
//            throws AlreadyExists, NotFound {
//        return cosmeticService.updateCosmetic(changeCosmeticDto, id);
//    }

    @Transactional
    public CosmeticDto deleteCosmetic(@PathVariable Long id) throws NotFound {
        Cosmetic cosmetic = cosmeticRepository.findById(id).orElseThrow(NotFound::new);
        cosmeticRepository.delete(cosmetic);
        return cosmeticMapper.toDto(cosmetic);
    }
}

