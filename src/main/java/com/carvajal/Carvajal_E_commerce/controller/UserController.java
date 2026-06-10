package com.carvajal.Carvajal_E_commerce.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.Carvajal_E_commerce.dto.Response.MessageResponseDTO;
import com.carvajal.Carvajal_E_commerce.dto.request.UserRequestDTO;
import com.carvajal.Carvajal_E_commerce.entity.UserEntity;
import com.carvajal.Carvajal_E_commerce.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
  
  private final UserService userService;

  @PostMapping()
  public UserEntity<MessageResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

    try {
      MessageResponseDTO
    }
  }
  
}
