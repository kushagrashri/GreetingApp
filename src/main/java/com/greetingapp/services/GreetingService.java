package com.greetingapp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage(){
        return "Hello world";
    }
}