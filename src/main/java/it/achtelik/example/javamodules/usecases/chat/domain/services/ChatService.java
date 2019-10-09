package it.achtelik.example.javamodules.usecases.chat.domain.services;

import it.achtelik.example.javamodules.usecases.chat.dataproviders.ChatCache;
import it.achtelik.example.javamodules.usecases.chat.domain.models.ChatMessage;

import java.util.List;

public class ChatService {

    private final ChatCache chatCache = new ChatCache();

    public boolean saveMessage(ChatMessage message) {
        return chatCache.writeMessage(message);
    }

    public List<ChatMessage> loadMessages() {
        return chatCache.readMessages();
    }
}
