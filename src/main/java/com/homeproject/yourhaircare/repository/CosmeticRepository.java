package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {


    List<Cosmetic> findAllByBrandIdAndTypeId(Long brandId, Long typeId);
    Cosmetic findByBrandNameAndNameAndTypeName(String brand, String name, String type);
    Cosmetic findByBrandIdAndNameAndTypeId(Long brandId, String name, Long typeId);
    Cosmetic findCosmeticById(Long id);
    List<Cosmetic> findAllByBrandNameAndTypeName(String brandName, String typeName);
    Cosmetic findCosmeticByNameAndTypeId(String name, Long id);
}

