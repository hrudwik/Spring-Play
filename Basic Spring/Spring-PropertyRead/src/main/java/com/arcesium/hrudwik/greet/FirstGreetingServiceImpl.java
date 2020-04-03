package com.arcesium.hrudwik.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("firstGreetingService")
public class FirstGreetingServiceImpl implements GreetingService {

    @Autowired
    private String name;

    @Override
    public String greet() {
        return "Hello " + name;
    }
}
