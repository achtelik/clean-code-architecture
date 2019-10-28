package it.achtelik.example.javamodules.usecases.chat;

import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.ports.ChatMessageRepositoryPort;
import it.achtelik.example.javamodules.usecases.chat.domain.services.ChatService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfiguration {

    @Bean
    public ChatService chatService(ChatMessageRepositoryPort chatMessageRepositoryPort) {
        return new ChatService(chatMessageRepositoryPort);
    }
}
