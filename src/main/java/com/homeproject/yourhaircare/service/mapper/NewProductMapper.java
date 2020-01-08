package com.homeproject.yourhaircare.service.mapper;

import com.homeproject.yourhaircare.model.NewProduct;
import com.homeproject.yourhaircare.service.dto.NewProductDto;
import org.springframework.stereotype.Component;

@Component
public class NewProductMapper {

    public NewProductDto toDto(NewProduct newProduct) {
        Long userId = null;
        if(newProduct.getUserAddProduct() != null) {
            userId = newProduct.getUserAddProduct().getId();
        }
        return NewProductDto.builder()
                .id(newProduct.getId())
                .userAddProductId(userId)
                .brand(newProduct.getBrand())
                .type(newProduct.getType())
                .feature(newProduct.getFeature())
                .name(newProduct.getName())
                .silicon(newProduct.getSilicon())
                .preservative(newProduct.getPreservative())
                .additionalInfo(newProduct.getAdditionalInfo())
                .addedAt(newProduct.getAddedAt())
                .updatedAt(newProduct.getUpdatedAt())
                .build();

    }


}
