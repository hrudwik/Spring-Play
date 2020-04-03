package com.arcesium.hrudwik.greet;

import org.springframework.stereotype.Component;

@Component("firstGreetingService")
public class FirstGreetingServiceImpl implements GreetingService {
    @Override
    public String greet() {
        return "Hello";
    }
}
