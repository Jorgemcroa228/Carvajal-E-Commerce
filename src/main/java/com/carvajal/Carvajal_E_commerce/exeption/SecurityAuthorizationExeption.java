package com.carvajal.Carvajal_E_commerce.exeption;

public class SecurityAuthorizationExeption extends RuntimeException{
  
    /**
     * Construye una nueva excepción de autorización con un mensaje detallado.
     * 
     * @param message El mensaje que explica la razón del fallo de seguridad
     */
    public SecurityAuthorizationExeption(String message) {
        super(message);
    }
}
