package it.achtelik.example.javamodules.usecases.chat;

import java.util.LinkedList;

public class ChatCache {
    public static LinkedList<ChatMessage> messages = new LinkedList<>();

    public boolean writeMessage(ChatMessage message) {
        synchronized (messages) {
            return messages.add(message);
        }
    }

    public LinkedList<ChatMessage> readMessages() {
        return messages;
    }
}
