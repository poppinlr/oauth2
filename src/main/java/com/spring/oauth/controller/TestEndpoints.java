package com.spring.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoints {

    @GetMapping("/resources/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/admin/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

    @GetMapping("/redirect")
    public String redirect() {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "redirect";
    }

    @GetMapping("/token")
    public String token() {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "token";
    }

}
