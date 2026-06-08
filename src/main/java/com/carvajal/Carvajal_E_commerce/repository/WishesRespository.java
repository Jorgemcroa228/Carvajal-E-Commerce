package com.carvajal.Carvajal_E_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvajal.Carvajal_E_commerce.entity.WishesEntity;

public interface WishesRespository extends JpaRepository<WishesEntity, Long>{
  
  List<WishesEntity> findByUserIdUser(Long idUser);
}
