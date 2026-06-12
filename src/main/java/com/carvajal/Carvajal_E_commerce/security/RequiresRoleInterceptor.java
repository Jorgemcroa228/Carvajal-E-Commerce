package com.carvajal.Carvajal_E_commerce.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.carvajal.Carvajal_E_commerce.enums.UserRole;

import io.jsonwebtoken.lang.Arrays;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequiresRoleInterceptor implements HandlerInterceptor{

  @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        if(!(handler instanceof HandlerMethod method)){
            return true;
        }

        RequiresRole requiresRole = method.getMethodAnnotation(RequiresRole.class);

        if(requiresRole == null){
            requiresRole = method.getBeanType().getAnnotation(RequiresRole.class);
        }

        if(requiresRole == null){
            return true;
        }

        Object rol = request.getAttribute("idRol");

        if(!(rol instanceof Long rolId)){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"User role not found in the request\"}");
            return false;
        }

        boolean hasRole = java.util.Arrays.stream(requiresRole.value()).anyMatch(role -> role.getId().equals(rolId));

        if(!hasRole){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"User does not have the required role\"}");
            return false;
        }

        return true;

    }
}
