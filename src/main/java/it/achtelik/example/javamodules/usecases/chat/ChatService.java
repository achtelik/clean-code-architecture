package it.achtelik.example.javamodules.usecases.chat;

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
