package com.carvajal.Carvajal_E_commerce.dto.Response;

import java.time.LocalDateTime;

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
public class WishesResponseDTO {
  
  private Long id_wishes;
  private LocalDateTime date_add;
}
