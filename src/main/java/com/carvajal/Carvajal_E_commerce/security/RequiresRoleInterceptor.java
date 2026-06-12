package com.carvajal.Carvajal_E_commerce.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.carvajal.Carvajal_E_commerce.enums.UserRole;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public class RequiresRoleInterceptor {

  UserRole[] value();
}
