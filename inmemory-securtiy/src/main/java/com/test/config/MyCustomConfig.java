package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class MyCustomConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req->req.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    UserDetailsService authenticationProvider(){
        UserDetails user1= User.withDefaultPasswordEncoder().username("xyz").password("12345").build();
        UserDetails user2=User.withDefaultPasswordEncoder().username("ab").password("abc").build();
        UserDetails user3=User.withDefaultPasswordEncoder().username("db").password("db1").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
