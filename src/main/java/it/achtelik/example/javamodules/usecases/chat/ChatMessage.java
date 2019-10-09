package it.achtelik.example.javamodules.usecases.chat;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ChatMessage {
    private final String text;

    @JsonCreator
    public ChatMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
