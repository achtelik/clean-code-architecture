package it.achtelik.clean_code_architecture.modules.chat.domain.models;

public class ChatMessage {
    private final String text;

    public ChatMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
