package br.rsea.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(
                authorize -> authorize.requestMatchers(HttpMethod.POST, "/criar/usuario").permitAll()
            .requestMatchers(HttpMethod.GET, "/livre").permitAll())
            .authorizeHttpRequests(
                authorize -> authorize.requestMatchers(HttpMethod.GET, "/comunidade").authenticated());
        return http.build();
 }


    @Bean
    public UserDetailsService userDetailsService() {
         UserDetails user = User.withDefaultPasswordEncoder()
             .username("ifsp")
             .password("1234")
             .build();

         return new InMemoryUserDetailsManager(user);
     }
}
