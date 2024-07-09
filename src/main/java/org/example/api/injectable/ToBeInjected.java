package org.example.api.injectable;

import org.springframework.stereotype.Component;

@Component //define essa classe como injetavel pelo Autowired
public class ToBeInjected {
    public void injectedHello(){
        System.out.println("HELLO INJECTED");
    }
}
