package com.arcesium.hrudwik.message;

import com.arcesium.hrudwik.greet.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("messageService")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageService {

    /*@Autowired
    @Qualifier("secondGreetingService")
    private GreetingService greetingService;*/

    @Autowired
    private GreetingService greetingService;

    public String getMessage() {
        return greetingService.greet();
    }
}
