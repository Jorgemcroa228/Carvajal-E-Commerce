package com.carvajal.Carvajal_E_commerce.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class ProductsEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_product")
  private long id_product;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private long price;

  @Column(name = "amount")
  private long amount;
}
