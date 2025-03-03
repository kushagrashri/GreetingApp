package com.greetingapp.controllers;

import com.greetingapp.services.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {


    @Autowired
    private GreetingService greetingService;

    public static final Logger logger = LoggerFactory.getLogger(HTTPSControllers.class);

    @GetMapping
    public String getMethod(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        logger.info("Calling get Method");
        return "{\"message\":\"" + greetingService.getGreetingMessage(firstName,lastName) + "\"}";
    }

    @PostMapping
    public String postMethod(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        logger.info("Calling post Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage(firstName,lastName)+"\"}";
    }

    @PutMapping
    public String putMethod(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        logger.info("Calling put Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage(firstName,lastName)+"\"}";
    }

    @DeleteMapping
    public String deleteMethod(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        logger.info("Calling delete Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage(firstName,lastName)+"\"}";
    }
}