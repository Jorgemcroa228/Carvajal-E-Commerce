package com.carvajal.Carvajal_E_commerce.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
  ADMIN(1L),
  CLIENTE(2L);

    private final Long id;
}
