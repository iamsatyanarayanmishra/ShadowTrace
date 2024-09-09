package com.kristellar.shadow_trace.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.kristellar.shadow_trace.backend.services.impl.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig {
    @Autowired
    private SecurityCustomUserDetailsService userDetailService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        // Configuration
        httpSecurity.authorizeHttpRequests(authorize->{
            authorize.requestMatchers( "/dashboard").authenticated();
            authorize.anyRequest().permitAll();
        });

        httpSecurity.formLogin(formLogin ->{
            formLogin.loginPage("/login");
            //formLogin.loginProcessingUrl("/authenticate");
            formLogin.successForwardUrl("/dashboard");
            formLogin.failureForwardUrl("/login?error=true");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");
        });
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
