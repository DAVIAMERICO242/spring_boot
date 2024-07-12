package org.example.api.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {//gerenciador de mensagens
        config.enableSimpleBroker("/topic"); // cria um topico para modular o websocket dentro do broker
        config.setApplicationDestinationPrefixes("/app"); // Define o prefixo para mensagens destinadas ao broker
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-chat") // Define o endpoint para conexões WebSocket em si
                .setAllowedOrigins("*") // Permite origens de todas as URLs (ajuste conforme necessário)
                .withSockJS(); // Habilita SockJS para suporte a fallback
    }
}