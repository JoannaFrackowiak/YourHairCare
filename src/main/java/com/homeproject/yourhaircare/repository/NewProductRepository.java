package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.NewProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewProductRepository extends JpaRepository<NewProduct, Long> {
}
