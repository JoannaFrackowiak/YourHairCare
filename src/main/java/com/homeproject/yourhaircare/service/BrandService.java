package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.repository.BrandRepository;
import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.dto.BrandDto;
import com.homeproject.yourhaircare.service.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> brandMapper.toDto(brand))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BrandDto> getAllBrandsForUser(String loggedUserEmail) {
        User user = userRepository.findUserByEmail(loggedUserEmail);
        // TODO - do dokonczenia
        return user.getCosmeticsOfUser().stream()
                .map(uc -> uc.getCosmeticUser().getBrand())
                .map(brandMapper::toDto)
                .collect(Collectors.toList());
    }
}
