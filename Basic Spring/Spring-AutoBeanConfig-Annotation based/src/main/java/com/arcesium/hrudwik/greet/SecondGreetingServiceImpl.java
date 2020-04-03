package com.arcesium.hrudwik.greet;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("secondGreetingService")
@Primary
public class SecondGreetingServiceImpl implements GreetingService {
    @Override
    public String greet() {
        return "Hola";
    }
}
