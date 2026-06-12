package com.carvajal.Carvajal_E_commerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carvajal.Carvajal_E_commerce.entity.WishListEntity;
import com.carvajal.Carvajal_E_commerce.repository.WishListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishListService {
  private final WishListRepository wishListRepository;


  /**
   * View the history 
   * 
   * @return
   */
  public List<WishListEntity> getHistoryByUser(Long userId) {

    return wishListRepository.findByUserId_user(userId);
}

  /**
   * get a registration from history
   * 
   * @param idWishList
   * @return
   */
  public WishListEntity getHistoryById(Long idWishList) {

    return wishListRepository.findById(idWishList)
            .orElseThrow(() ->new RuntimeException("Registro histórico no encontrado"));
    }

  /**
   * Delete registartion from history
   * 
   * @param idWishList
   */
  public void deleteHistory(Long idWishList) {

    WishListEntity history = wishListRepository.findById(idWishList)
            .orElseThrow(() -> new RuntimeException("Registro histórico no encontrado"));

        wishListRepository.delete(history);
    }
}
