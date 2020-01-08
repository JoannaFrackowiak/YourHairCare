package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.SiliconCosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiliconCosmeticRepository extends JpaRepository<SiliconCosmetic, Long> {
}
