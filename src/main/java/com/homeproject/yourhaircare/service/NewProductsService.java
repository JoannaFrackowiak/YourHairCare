package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.NewProduct;
import com.homeproject.yourhaircare.repository.NewProductRepository;
import com.homeproject.yourhaircare.service.dto.CreateUpdateNewProductDto;
import com.homeproject.yourhaircare.service.dto.NewProductDto;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.mapper.NewProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Service
public class NewProductsService {
    @Autowired
    private NewProductRepository newProductRepository;
    @Autowired
    private NewProductMapper mapper;

    @Transactional
    public NewProductDto createNewProduct(CreateUpdateNewProductDto dto) throws BadRequest {
        NewProduct newProduct = NewProduct.builder()
                .brand(dto.getBrand())
                .type(dto.getType())
                .feature(dto.getFeature())
                .name(dto.getName())
                .additionalInfo(dto.getAdditionalInfo())
                .addedAt(OffsetDateTime.now())
                .build();
        switch (dto.getSilicon()) {
            case "no":
                newProduct.setSilicon(false);
                break;
            case "yes":
                newProduct.setSilicon(true);
                break;
            default:
                newProduct.setSilicon(null);
        }
        switch (dto.getPreservative()) {
            case "no":
                newProduct.setPreservative(false);
                break;
            case "yes":
                newProduct.setPreservative(true);
                break;
            default:
                newProduct.setPreservative(null);
        }
        NewProduct savedProduct = newProductRepository.save(newProduct);
        return mapper.toDto(savedProduct);
    }

}


