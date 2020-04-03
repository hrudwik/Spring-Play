package com.arcesium.hrudwik.message;

import com.arcesium.hrudwik.greet.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

public class MessageService {

    @Autowired
    @Qualifier("secondGreetingService")
    private GreetingService greetingService;

    public String getMessage() {
        return greetingService.greet();
    }
}
