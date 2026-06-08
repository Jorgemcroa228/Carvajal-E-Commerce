package com.carvajal.Carvajal_E_commerce.dto.request;

import java.time.LocalDateTime;

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
public class WhisesRequestDto {
  
  @NotBlank(message = "This field is required.")
  @Column(name = "date_add")
  private LocalDateTime date_add;
}
