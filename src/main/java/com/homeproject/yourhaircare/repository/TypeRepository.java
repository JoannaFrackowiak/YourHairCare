package com.homeproject.yourhaircare.repository;

import com.homeproject.yourhaircare.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findTypeById(Long id);

    Type findTypeByName(String name);
}

