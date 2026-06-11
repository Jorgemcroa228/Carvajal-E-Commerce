package com.carvajal.Carvajal_E_commerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.Carvajal_E_commerce.entity.WishListEntity;
import com.carvajal.Carvajal_E_commerce.service.WishListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishList")
public class WishListController {
  
  private final WishListService wishListService;

    /**
     * View all history of a user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WishListEntity>> getHistoryByUser(
            @PathVariable Long userId) {

        List<WishListEntity> history =
                wishListService.getHistoryByUser(userId);

        return ResponseEntity.ok(history);
    }

    /**
     * Search history registration by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<WishListEntity> getHistoryById(
            @PathVariable Long id) {

        WishListEntity history =
                wishListService.getHistoryById(id);

        return ResponseEntity.ok(history);
    }

    /**
     * Delete registration history
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistory(
            @PathVariable Long id) {

        wishListService.deleteHistory(id);

        return ResponseEntity.ok(
                "Registro histórico eliminado correctamente");
    }
}
