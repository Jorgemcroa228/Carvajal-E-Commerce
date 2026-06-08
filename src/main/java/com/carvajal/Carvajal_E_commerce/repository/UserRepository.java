package com.carvajal.Carvajal_E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvajal.Carvajal_E_commerce.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
  boolean existsByEmail(String email);
}
