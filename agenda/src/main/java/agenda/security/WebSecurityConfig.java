package agenda.security;

import agenda.entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig {


    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {


        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( authz -> authz

                        .requestMatchers("/admin/**").hasAuthority("ROLE_" + Rol.ADMIN)
                        .requestMatchers("/entrenador/**").hasAuthority("ROLE_" + Rol.ENTRENADOR)
                        .requestMatchers("/user/**").hasAuthority("ROLE_" + Rol.USER)
                        /*
                        .requestMatchers("/admin/**").hasAuthority("ROLE_" + Rol.ADMIN)
                        .requestMatchers("/entrenador/**").hasAuthority("ROLE_" + Rol.ENTRENADOR)
                        .requestMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ROLE_" + Rol.USER)
                        .requestMatchers(HttpMethod.GET, "/user/**").hasAuthority("ROLE_" + Rol.USER)
                        .requestMatchers(HttpMethod.PUT, "/user/**").hasAuthority("ROLE_" + Rol.USER)

                         */
                        .anyRequest().permitAll())
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

