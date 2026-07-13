package com.security.security_example.controller.impl;

import com.security.security_example.controller.IBaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/base/v1")
public class BaseController implements IBaseController {

    @GetMapping(path = "/base-endpoint")
    public ResponseEntity<String> greet(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello World");
    }

}
