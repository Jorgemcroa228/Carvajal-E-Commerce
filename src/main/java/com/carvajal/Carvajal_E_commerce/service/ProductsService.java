package com.carvajal.Carvajal_E_commerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carvajal.Carvajal_E_commerce.entity.ProductsEntity;
import com.carvajal.Carvajal_E_commerce.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {

  private final ProductsRepository productRepository;

  public List<ProductsEntity> getAllProducts() {
      return productRepository.findAll();
  }

  public ProductsEntity getProductById(Long id) {
      return productRepository.findById(id)
              .orElseThrow(() ->
                      new RuntimeException("Producto no encontrado"));
    }
}
