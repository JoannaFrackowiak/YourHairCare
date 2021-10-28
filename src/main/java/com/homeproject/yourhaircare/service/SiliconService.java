package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.repository.CosmeticRepository;
import com.homeproject.yourhaircare.service.dto.SiliconDto;
import com.homeproject.yourhaircare.service.mapper.SiliconMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiliconService {

    @Autowired
    private CosmeticRepository cosmeticRepository;
    @Autowired
    private SiliconMapper siliconMapper;


    @Transactional
    public List<SiliconDto> getAllSiliconForCosmetic(Long cosmeticId) {
        Cosmetic cosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        return cosmetic.getSiliconsInCosmetic()
                .stream()
                .map(siliconCosmetic -> siliconCosmetic.getSilicon())
                .map(silicon -> siliconMapper.toDto(silicon))
                .collect(Collectors.toList());

    }

}

