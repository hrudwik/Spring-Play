package com.arcesium.hrudwik;

import com.arcesium.hrudwik.configuration.AppConfig;
import com.arcesium.hrudwik.message.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = (MessageService)context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
