package it.achtelik.example.javamodules.usecases.chat.domain.models;

public class ChatMessage {
    private final String text;

    public ChatMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
