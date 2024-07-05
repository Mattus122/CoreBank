package com.example.corebank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails manan = User.builder()
                .username("manan")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails john = User.builder()
                .username("John")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("Susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(manan, john, susan);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(configurer->
                configurer.requestMatchers(HttpMethod.GET , "/v1/users/** ").hasAnyRole("EMPLOYEE" , "MANAGER ")
                        .requestMatchers(HttpMethod.POST , "/v1/users/** ").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET , "/v1/users/** ").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET , "/v1/users/** ").hasRole("EMPLOYEE")

        );
        http.httpBasic(Customizer.withDefaults());
        //disable csrf not used in rest api's only in web aplicatons
         http.csrf(csrf->csrf.disable());
         return http.build();
    }
}
