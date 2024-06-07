package com.parcial2.utils;

import com.parcial2.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    private final PasswordEncoder passwordEncoder;

    private final UserService userService;
    //falta agregar para el jwtToken
    public WebSecurityConfiguration(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //http login and  Deshabilita la protección CSRF, útil para APIs REST donde se usa JWT para la autenticación.
        http.httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable());

        //Route filter, Permite el acceso sin autenticación a todas las rutas que comienzan con /api/auth/.
        http.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
        );
        //Statelessness
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //Manejo de errores de autentificacion no autorizados
        http.exceptionHandling(handling -> handling.authenticationEntryPoint((req, res, ex) -> {
            res.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Auth fail!"
            );
        }));

        //JWT filter
        //http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
