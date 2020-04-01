package com.arcesium.hrudwik.greet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("secondGreetingService")
@Primary
public class SecondGreetingServiceImpl implements GreetingService {

    @Value("${name:world}")
    private String name;

    @Override
    public String greet() {

        return "Hola " + name;
    }
}
