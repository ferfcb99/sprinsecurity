package com.security.security_example.controller.impl;

import com.security.security_example.controller.ISecurityController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

@RestController
@RequestMapping(path = "/api/v1/security")
public class SecurityController implements ISecurityController {

    @GetMapping(path = "/base-endpoint")
    public ResponseEntity<String> greet(){
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello World");
    }

}
