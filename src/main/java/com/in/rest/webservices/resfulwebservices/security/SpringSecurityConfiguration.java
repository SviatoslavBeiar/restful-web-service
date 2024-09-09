package com.in.rest.webservices.resfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         //All requests auth
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );


        http.httpBasic(Customizer.withDefaults());


        http.csrf().disable();


        return http.build();
    }*/
//   @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//           http
//               .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//               .httpBasic(Customizer.withDefaults())
//               .csrf((csrf) -> csrf.disable()) // updated line
//               .build();
//           return http.build();
//   }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())

                .csrf(csrf -> csrf.disable()); // Corrected line: Remove the second build call
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        return http.build(); // Only one build call
    }

}
