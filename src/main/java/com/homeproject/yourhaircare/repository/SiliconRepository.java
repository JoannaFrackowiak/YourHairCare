package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.Silicon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiliconRepository extends JpaRepository<Silicon, Long> {
}
