package com.example.GreetingProj.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("englishGreeting")
public class HelloGreetingServiceImpl implements GreetingService {
    @Autowired
    private String name;

    @Override
    public String greet() {
        return "Hello " + name;
    }
}
