package com.carvajal.Carvajal_E_commerce.service;

import org.springframework.stereotype.Service;

import com.carvajal.Carvajal_E_commerce.entity.ProductsEntity;
import com.carvajal.Carvajal_E_commerce.entity.UserEntity;
import com.carvajal.Carvajal_E_commerce.entity.WishesEntity;
import com.carvajal.Carvajal_E_commerce.repository.ProductsRepository;
import com.carvajal.Carvajal_E_commerce.repository.UserRepository;
import com.carvajal.Carvajal_E_commerce.repository.WishesRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishesService {
  
    private final WishesRespository wishesRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;
    private final HistoricoDeseosRepository historicoRepository;

    public WishesEntity addWish(WishesRequestDTO request) {

    UserEntity user = userRepository.findById(request.getIdUser())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    ProductsEntity product = productsRepository.findById(request.getIdProduct())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    WishesEntity wish = new WishesEntity();
    wish.setUser(user);
    wish.setProduct(product);

    WishesEntity savedWish = wishesRepository.save(wish);

    saveHistory(user, product, "AGREGADO");

    return savedWish;
}
}
