package com.carvajal.Carvajal_E_commerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.Carvajal_E_commerce.dto.Response.MessageResponseDTO;
import com.carvajal.Carvajal_E_commerce.dto.request.WishesRequestDTO;
import com.carvajal.Carvajal_E_commerce.entity.WishesEntity;
import com.carvajal.Carvajal_E_commerce.service.WishesService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishes")
public class WishesController {
  
  private final WishesService wishesService;

    /**
     * Add product to wishes
     * 
     * @param request
     * @return
     */
  @PostMapping
  public ResponseEntity<WishesEntity> addWish(@Valid @RequestBody WishesRequestDTO request) {

    WishesEntity wish = wishesService.addWish(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(wish);
    }

  /**
   * Search Wish from user
   * 
   * @param userId
   * @return
   */
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<String>> getWishesByUser(@PathVariable Long userId) {

    List<String> wishes = wishesService.getWishesByUser(userId);

      return ResponseEntity.ok(wishes);
    }

    /**
     * Update wish
     * 
     * @param idWish
     * @param request
     * @return
     */
    @PutMapping("/{idWish}")
    public ResponseEntity<WishesEntity> updateWish(@PathVariable Long idWish, @Valid @RequestBody WishesRequestDTO request) {

      WishesEntity updatedWish = wishesService.updateWish(idWish, request);

      return ResponseEntity.ok(updatedWish);
    }

    // Eliminar un deseo
    @DeleteMapping("/{idWish}")
    public ResponseEntity<MessageResponseDTO> deleteWish(@PathVariable Long idWish) {

      wishesService.deleteWish(idWish);

      return ResponseEntity.ok(new MessageResponseDTO("Deseo eliminado correctamente")
        );
    }
}
