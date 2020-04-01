package com.arcesium.hrudwik.greet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("firstGreetingService")
public class FirstGreetingServiceImpl implements GreetingService {

    @Value("${name:world}")
    private String name;

    @Override
    public String greet() {
        return "Hello " + name;
    }
}
