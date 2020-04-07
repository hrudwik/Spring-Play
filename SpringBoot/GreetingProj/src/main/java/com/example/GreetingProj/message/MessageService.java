package com.example.GreetingProj.message;

import com.example.GreetingProj.greet.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Qualifier("englishGreeting")
    @Autowired
    private GreetingService greetingService;

    public String getMessage() {
        return greetingService.greet();
    }
}