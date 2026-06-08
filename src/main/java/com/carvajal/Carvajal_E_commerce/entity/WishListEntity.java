package com.carvajal.Carvajal_E_commerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "wish_list")
public class WishListEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_wishList")
  private Long id_wishList;

  @ManyToOne
  @JoinColumn(name = "id_user", nullable = false)
  private UserEntity user;

  @ManyToOne 
  @JoinColumn(name = "id_product", nullable = false)
  private ProductsEntity product;

  @Column(name = "action")
  private String action;

  @Column(name = "date")
  private LocalDateTime date;
}
