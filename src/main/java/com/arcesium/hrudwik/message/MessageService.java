package com.arcesium.hrudwik.message;

import com.arcesium.hrudwik.greet.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageService {
    private GreetingService greetingService;

    MessageService() { }
    MessageService(GreetingService greetingService) { this.greetingService = greetingService; }

    public GreetingService getGreetingService() { return greetingService; }

    public void setGreetingService(GreetingService greetingService) { this.greetingService = greetingService; }

    public String getMessage() {
        return greetingService.greet();
    }
}
