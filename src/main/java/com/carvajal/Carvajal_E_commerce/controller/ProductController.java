package com.carvajal.Carvajal_E_commerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.Carvajal_E_commerce.entity.ProductsEntity;
import com.carvajal.Carvajal_E_commerce.service.ProductsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
  private final ProductsService productsService;

    /**
     * List all products
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProductsEntity>> getAllProducts() {

        List<ProductsEntity> products =
                productsService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    /**
     * Search by id
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductsEntity> getProductById(
            @PathVariable Long id) {

        ProductsEntity product =
                productsService.getProductById(id);

        return ResponseEntity.ok(product);
    }
}
