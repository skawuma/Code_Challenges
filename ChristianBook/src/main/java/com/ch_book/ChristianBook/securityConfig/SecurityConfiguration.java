package com.ch_book.ChristianBook.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

     private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private static final String DELETE = "DELETE";


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods(GET, POST, PUT, DELETE)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);
            }
        };
    }
	
	@Autowired
	private  JwtFilter jwtRequestFilter;
	
	
	

@Primary
@Bean
public UserDetailsService  customerUserDetailService ()
{

    return new CustomerUserDetailsService ();
}

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         
        authProvider.setUserDetailsService(customerUserDetailService ());
        authProvider.setPasswordEncoder(passwordEncoder());
     
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @ConditionalOnClass
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }






@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
    .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
    //.cors()
    .and()
    .csrf() 
    .disable()
    
    .authorizeHttpRequests()

            .requestMatchers("/api/v1/user/login","/api/v1/user/signup").permitAll() 
          // .requestMatchers("/user/get","/user/getall","/user/update").hasRole("Admin")
          /// .requestMatchers("/category/add","/category/get","/category/update").hasRole("Admin")
             //.requestMatchers("/user/changePassword").hasAnyRole("Admin","User")
             //.requestMatchers(HttpMethod.PUT,"/user/update").hasAnyRole("Admin","User")
            .anyRequest()
            .authenticated()
            .and()
            // .headers().httpStrictTransportSecurity().disable()
            // .and()
            .exceptionHandling()
            .and()
            
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
}





    
}
