package it.achtelik.clean_code_architecture.modules.chat.entrypoints.mappers;

import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;
import it.achtelik.clean_code_architecture.modules.chat.entrypoints.models.ChatMessageDto;

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
