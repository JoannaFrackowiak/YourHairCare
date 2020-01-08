package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.DailyUserCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyUserCareRepository extends JpaRepository<DailyUserCare, Long> {
}
