package it.achtelik.clean_code_architecture.modules.chat.entrypoints.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatMessageDto {
    private final String text;

    @JsonCreator
    public ChatMessageDto(@JsonProperty("text") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
