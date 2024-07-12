package org.example.api.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat") // Endpoint para o frontend enviar mensagens, no frontend sera /app/chat
    @SendTo("/topic") // Endpoint para o frontend receber mensagens desse topico, no frontend e so /topico
    public String sendMessage(String message) {
        return "Mensagem recebida: " + message;
    }
}