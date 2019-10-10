package it.achtelik.example.javamodules.usecases.chat.entrypoints.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ChatMessageDto {
    private final String text;

    @JsonCreator
    public ChatMessageDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
