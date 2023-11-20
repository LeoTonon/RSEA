package br.rsea.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import br.rsea.security.service.MyUserDetailServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().requiresChannel(
            channel -> channel.anyRequest().requiresSecure())
            .authorizeHttpRequests(
                authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/criar/usuario").permitAll()
                .requestMatchers(HttpMethod.POST, "/criar/comunidade").permitAll())
                .authorizeHttpRequests(
                authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/listar/comunidades").authenticated()
                .requestMatchers(HttpMethod.GET, "/listar/moderadores").authenticated()
                .requestMatchers(HttpMethod.GET, "/listar/usuarios").authenticated()
                .requestMatchers(HttpMethod.PUT, "/moderador/{id}").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/{comunidade}/{id}").authenticated())
            .httpBasic(Customizer.withDefaults());
                return http.build();
 }
    @Bean
    public UserDetailsService myUserDetailsService() {
        return new MyUserDetailServices();
 }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
 }
}