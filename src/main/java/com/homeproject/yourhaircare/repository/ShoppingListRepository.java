package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.ShoppingList;
import com.homeproject.yourhaircare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findByUserShopListEmail(String email);
}
