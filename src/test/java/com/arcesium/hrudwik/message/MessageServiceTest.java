package com.arcesium.hrudwik.message;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Beans-test.xml"})
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Test
    public void getMessage() {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans-test.xml");
        //messageService = (MessageService) applicationContext.getBean("messageServiceTest");
        String msg = messageService.getMessage();
        assertEquals("Hello", msg);
    }
}