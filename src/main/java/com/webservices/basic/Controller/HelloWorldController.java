package com.webservices.basic.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class HelloWorldController {

    @GetMapping()
    public String test(){
        return "testing";
    }

}
