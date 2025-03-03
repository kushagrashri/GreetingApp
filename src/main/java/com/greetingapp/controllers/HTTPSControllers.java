package com.greetingapp.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/httpMethods")
public class HTTPSControllers {

    public static final Logger logger = LoggerFactory.getLogger(HTTPSControllers.class);

    @GetMapping
    public String getMethod(){
        logger.info("Calling get Method");
        return "{\"message\" : \"I am get method\"}";
    }

    @PostMapping
    public String postMethod(){
        logger.info("Calling post Method");
        return "{\"message\" : \"I am post method\"}";
    }

    @PutMapping
    public String putMethod(){
        logger.info("Calling put Method");
        return "{\"message\" : \"I am put method\"}";
    }

    @DeleteMapping
    public String deleteMethod(){
        logger.info("Calling delete Method");
        return "{\"message\" : \"I am delete method\"}";
    }
}