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
    public String getMethod(){
        logger.info("Calling get Method");
        return "{\"message\":\"" + greetingService.getGreetingMessage() + "\"}";
    }

    @PostMapping
    public String postMethod(){
        logger.info("Calling post Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage()+"\"}";
    }

    @PutMapping
    public String putMethod(){
        logger.info("Calling put Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage()+"\"}";
    }

    @DeleteMapping
    public String deleteMethod(){
        logger.info("Calling delete Method");
        return "{\"message\" : \""+greetingService.getGreetingMessage()+"\"}";
    }
}