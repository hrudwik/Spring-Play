package com.arcesium.hrudwik;

import com.arcesium.hrudwik.message.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        MessageService messageService = (MessageService) context.getBean("messageService");
        System.out.println(messageService.getMessage());
    }
}
