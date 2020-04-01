package com.arcesium.hrudwik.message;

import com.arcesium.hrudwik.configuration.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Value("${name:world}")
    private String name;

    @Test
    public void getMessage() {
        String msg = messageService.getMessage();
        assertEquals("Hola "+name, msg);
    }
}