package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {

    List<Cosmetic> findAllByBrand(String brand);
    Cosmetic findCosmeticByBrandAndNameAndType(Long brandId, String name, Long typeId);
}
