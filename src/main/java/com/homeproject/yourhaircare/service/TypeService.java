package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.repository.FeatureRepository;
import com.homeproject.yourhaircare.repository.TypeRepository;
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
}
