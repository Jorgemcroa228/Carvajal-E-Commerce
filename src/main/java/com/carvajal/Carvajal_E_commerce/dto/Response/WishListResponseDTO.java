package com.carvajal.Carvajal_E_commerce.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WishListResponseDTO {
  
  private Long id_WishList;
  private Long id_user;
  private Long id_product;
  private String action;
}
