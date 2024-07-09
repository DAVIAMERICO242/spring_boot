package org.example.api.injectable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyManager {
    @Bean
    public ToBeInjected anynome(){
        return new ToBeInjected();
    }
}
