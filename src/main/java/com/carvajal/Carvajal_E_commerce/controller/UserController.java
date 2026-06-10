package com.carvajal.Carvajal_E_commerce.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.Carvajal_E_commerce.dto.Response.DeleteUserResponseDTO;
import com.carvajal.Carvajal_E_commerce.dto.Response.UserResponseDTO;
import com.carvajal.Carvajal_E_commerce.dto.request.UserRequestDTO;
import com.carvajal.Carvajal_E_commerce.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
  
  private final UserService userService;

  /**
   * 
   * @param userRequestDTO
   * @return
   */
  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

    UserResponseDTO response = userService.createUser(userRequestDTO);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response);
  }
  
  /**
   * 
   * @return
   */
  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> listUsers() {

      List<UserResponseDTO> users = userService.listUser();

      return ResponseEntity.ok(users);
    }

  /**
   * 
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {

      UserResponseDTO user = userService.showById(id);

      return ResponseEntity.ok(user);
    }

  /**
   * 
   * @param id
   * @param request
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequestDTO request) {

      UserResponseDTO updatedUser = userService.updateById(id, request);

      return ResponseEntity.ok(updatedUser);
    }

  /**
   * 
   * @param id
   * @return
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<DeleteUserResponseDTO> deleteUser(@PathVariable Long id) {

      DeleteUserResponseDTO response = userService.deltedUserById(id);

      return ResponseEntity.ok(response);
    }

}
