package dev.kyky.NR;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurations {
    
    private final JWTFilter jwtFilter;

    public SecurityConfigurations(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configurationSource(request -> {
                var source = new org.springframework.web.cors.CorsConfiguration();
                source.setAllowCredentials(true);

                source.addAllowedOrigin("https://ninja-rebirth-front.vercel.app");
                source.addAllowedOrigin("http://localhost:5173");

                source.addAllowedMethod(HttpMethod.GET);
                source.addAllowedMethod(HttpMethod.POST);
                source.addAllowedMethod(HttpMethod.PUT);
                source.addAllowedMethod(HttpMethod.DELETE);
                source.addAllowedMethod(HttpMethod.OPTIONS);

                source.addAllowedHeader("Content-Type");
                source.addAllowedHeader("Token");

                return source;
            }))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(HttpMethod.GET,
                    "/",
                    "/{id}",
                    "/search"
                ).permitAll()
                .requestMatchers(HttpMethod.POST,
                    "/register",
                    "/login"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    BCryptPasswordEncoder BCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
