package com.bruna.scorecheckerapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//Tells application that the routes (e.g /customer; /debit/login) are no longer opened - they need to pass through authentication
@EnableWebSecurity
public class SecurityConfigurations  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //Enabling access to my public End Points (No authentication needed)
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated()
                // CSRF is a sort of hacking attack.
                // Because the application is authenticating the user by its token.
                // There is no necessity to handle that attack. That is why CSRF is disabled
                .and().csrf().disable()
                //Telling Spring Security that the authentication will no longer use session, it will use token instead
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors();
                //.and()
                //Adding the filter that will be executed before every request
                    //.addFilterBefore(new AuthenticationInterceptor(authenticationService, userRepository), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
