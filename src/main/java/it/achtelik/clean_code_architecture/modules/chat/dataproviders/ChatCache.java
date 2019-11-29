package it.achtelik.clean_code_architecture.modules.chat.dataproviders;

import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;

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
