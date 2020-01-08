package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.ShoppingListCosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListCosmeticRepository extends JpaRepository<ShoppingListCosmetic, Long> {
}
