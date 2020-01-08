package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.UserCosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCosmeticRepository extends JpaRepository<UserCosmetic, Long> {
}
