package com.carvajal.Carvajal_E_commerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WishListRequestDTO {
  
  @NotBlank(message = "User id is required")
  private Long id_User;

  @NotBlank(message = "Product id is required")
  private Long id_Product;

  @NotBlank(message = "Action is required.")
  private String action;
}
