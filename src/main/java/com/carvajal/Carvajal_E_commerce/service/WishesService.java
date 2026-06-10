package com.carvajal.Carvajal_E_commerce.service;

import com.carvajal.Carvajal_E_commerce.repository.WishListRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carvajal.Carvajal_E_commerce.dto.request.WishesRequestDTO;
import com.carvajal.Carvajal_E_commerce.entity.ProductsEntity;
import com.carvajal.Carvajal_E_commerce.entity.UserEntity;
import com.carvajal.Carvajal_E_commerce.entity.WishListEntity;
import com.carvajal.Carvajal_E_commerce.entity.WishesEntity;
import com.carvajal.Carvajal_E_commerce.repository.ProductsRepository;
import com.carvajal.Carvajal_E_commerce.repository.UserRepository;
import com.carvajal.Carvajal_E_commerce.repository.WishesRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishesService {

  private final WishListRepository wishListRepository;
  private final WishesRespository wishesRepository;
  private final UserRepository userRepository;
  private final ProductsRepository productsRepository;


    public WishesEntity addWish(WishesRequestDTO request) {

    UserEntity user = userRepository.findById(request.getId_User())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    ProductsEntity product = productsRepository.findById(request.getId_Product())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    WishesEntity wish = new WishesEntity();
    wish.setUser(user);
    wish.setProduct(product);

    WishesEntity savedWish = wishesRepository.save(wish);

    saveHistory(user, product, "AGREGADO");

    return savedWish;
}

public List<String> getWishesByUser(Long userId) {

    List<WishesEntity> wishes = wishesRepository.findByUserIdUser(userId);

    return wishes.stream()
            .map(wish -> {

                ProductsEntity product = wish.getProduct();

                if(product.getAmount() <= 0){
                    return product.getName() + " - SIN STOCK";
                }

                return product.getName() + " - Disponible";
            })
            .toList();
}

public WishesEntity updateWish(Long idWish, WishesRequestDTO request) {

    WishesEntity wish = wishesRepository.findById(idWish)
            .orElseThrow(() -> new RuntimeException("Deseo no encontrado"));

    ProductsEntity newProduct = productsRepository.findById(request.getId_Product())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    wish.setProduct(newProduct);

    WishesEntity updatedWish = wishesRepository.save(wish);

    saveHistory(
            wish.getUser(),
            newProduct,
            "ACTUALIZADO"
    );

    return updatedWish;
}

public void deleteWish(Long idWish) {

    WishesEntity wish = wishesRepository.findById(idWish)
            .orElseThrow(() -> new RuntimeException("Deseo no encontrado"));

    saveHistory(
            wish.getUser(),
            wish.getProduct(),
            "ELIMINADO"
    );

    wishesRepository.delete(wish);
}

private void saveHistory(UserEntity user,
                      ProductsEntity product,
                      String action){

    WishListEntity history = new WishListEntity();

    history.setUser(user);
    history.setProduct(product);
    history.setAction(action);

    wishListRepository.save(history);
}
}
