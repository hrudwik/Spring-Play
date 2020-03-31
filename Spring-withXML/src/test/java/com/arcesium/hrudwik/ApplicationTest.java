package com.arcesium.hrudwik;

import com.arcesium.hrudwik.message.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:/Beans.xml"})
//@ContextConfiguration(locations = "classpath:Beans.xml")
public class ApplicationTest implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void messageTest() {
        messageService = (MessageService) applicationContext.getBean("messageService");
        String msg = messageService.getMessage();
        assertEquals("Hello", msg);
    }
}