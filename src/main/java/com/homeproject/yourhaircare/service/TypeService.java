package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.Type;
import com.homeproject.yourhaircare.repository.TypeRepository;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.TypeDto;
import com.homeproject.yourhaircare.service.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    public List<TypeDto> getAllTypes() {
        return typeRepository.findAll()
                .stream()
                .map(brand -> typeMapper.toDto(brand))
                .collect(Collectors.toList());
    }

    @Transactional
    public TypeDto getOneType(String name) {
        Type type = typeRepository.findTypeByName(name);
        return typeMapper.toDto(type);
    }

    public List<TypeDto> getAllTypesForUser(List<CosmeticDto> cosmeticDtoList) {
        return cosmeticDtoList.stream()
                .map(cosmeticDto -> cosmeticDto.getTypeId())
                .map(id -> typeRepository.findTypeById(id))
                .map(type -> typeMapper.toDto(type))
                .collect(Collectors.toList());
    }
}
