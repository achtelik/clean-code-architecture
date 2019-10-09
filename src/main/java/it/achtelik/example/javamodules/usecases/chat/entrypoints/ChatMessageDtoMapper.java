package it.achtelik.example.javamodules.usecases.chat.entrypoints;

import it.achtelik.example.javamodules.usecases.chat.domain.models.ChatMessage;

import java.util.List;
import java.util.stream.Collectors;

public class ChatMessageDtoMapper {

    public static ChatMessage toChatMessage(ChatMessageDto chatMessageDto) {
        return new ChatMessage(chatMessageDto.getText());
    }

    public static List<ChatMessageDto> fromChatMessages(List<ChatMessage> chatMessages) {
        return chatMessages.stream().map(ChatMessageDtoMapper::fromChatMessage).collect(Collectors.toList());
    }

    public static ChatMessageDto fromChatMessage(ChatMessage chatMessage) {
        return new ChatMessageDto(chatMessage.getText());
    }
}
