package com.carvajal.Carvajal_E_commerce.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carvajal.Carvajal_E_commerce.filter.JwtValidationFilter;

@Configuration
public class FilterConfig {
  
  @Bean
    FilterRegistrationBean<JwtValidationFilter> jwtfilter(JwtValidationFilter jwtValidationFilter){

        FilterRegistrationBean<JwtValidationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(jwtValidationFilter);

        registrationBean.addUrlPatterns("/*");

        registrationBean.setOrder(1);

        return registrationBean;
    }
}
