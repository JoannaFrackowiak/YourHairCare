package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    List<Brand> findAllByName(String name);
    Brand findBrandById(Long id);
    Brand findBrandByName(String name);

}
