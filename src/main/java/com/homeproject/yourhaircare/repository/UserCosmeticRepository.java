package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.UserCosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCosmeticRepository extends JpaRepository<UserCosmetic, Long> {

    List<UserCosmetic> findAllByUserCosmeticId (Long UserCosmeticId);

    UserCosmetic findByUserCosmeticIdAndCosmeticUserId(Long id, Long id1);

//    UserCosmetic findUserCosmeticByUserIdAndCosmeticId(Long id, Long id1);
}

