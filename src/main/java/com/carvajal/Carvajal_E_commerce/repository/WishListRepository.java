package com.carvajal.Carvajal_E_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvajal.Carvajal_E_commerce.entity.WishListEntity;

public interface WishListRepository extends JpaRepository<WishListEntity, Long>{
  
  List<WishListEntity> findByUserId_user(Long userId);
}
