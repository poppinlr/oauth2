//package com.spring.oauth.config;
//
//import com.spring.oauth.service.security.config.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@EnableWebSecurity
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private UserService userService;
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        return userService;
//    }
//}