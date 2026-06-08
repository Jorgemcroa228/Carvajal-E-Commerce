package com.carvajal.Carvajal_E_commerce.dto.request;

import jakarta.persistence.Column;
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
public class ProductsRequestDTO {
  
  @NotBlank(message = "This field is requiered.")
  @Column(name = "name")
  private String name;

  @NotBlank(message = "This field is requiered.")
  @Column(name = "price")
  private String price;

  @NotBlank(message = "This field is requiered.")
  @Column(name = "amount")
  private String amount;
}
