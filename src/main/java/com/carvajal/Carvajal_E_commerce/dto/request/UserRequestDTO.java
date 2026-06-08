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
public class UserRequestDTO {

    @NotBlank(message = "This field is required.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "This field is required.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "This field is required.")
    @Column(name = "password")
    private String password;
}
