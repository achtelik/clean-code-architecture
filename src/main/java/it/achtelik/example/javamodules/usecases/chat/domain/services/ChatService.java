package it.achtelik.example.javamodules.usecases.chat.domain.services;

import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.ports.ChatMessageRepositoryPort;
import it.achtelik.example.javamodules.usecases.chat.domain.models.ChatMessage;

import java.util.List;

public class ChatService {

    ChatMessageRepositoryPort chatMessageRepositoryPort;

    public ChatService(ChatMessageRepositoryPort chatMessageRepositoryPort) {
        this.chatMessageRepositoryPort = chatMessageRepositoryPort;
    }

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepositoryPort.save(message);
    }

    public List<ChatMessage> loadMessages() {
        return chatMessageRepositoryPort.findAll();
    }
}
