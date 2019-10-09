package it.achtelik.example.javamodules.usecases.chat;

public class ChatMessage {
    private final String text;

    public ChatMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
