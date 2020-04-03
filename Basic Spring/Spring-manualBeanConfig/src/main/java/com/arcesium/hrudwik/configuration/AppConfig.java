package com.arcesium.hrudwik.configuration;

import com.arcesium.hrudwik.greet.FirstGreetingServiceImpl;
import com.arcesium.hrudwik.greet.SecondGreetingServiceImpl;
import com.arcesium.hrudwik.message.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FirstGreetingServiceImpl firstGreetingService() {
        return new FirstGreetingServiceImpl();
    }

    @Bean
    public SecondGreetingServiceImpl secondGreetingService() {
        return new SecondGreetingServiceImpl();
    }

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }
}
