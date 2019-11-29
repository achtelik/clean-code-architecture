package it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.mappers;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.entities.ChatMessageEntity;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ChatMessageEntityMapper {

    public static ChatMessageEntity fromChatMessage(ChatMessage chatMessage) {
        return new ChatMessageEntity(chatMessage.getText());
    }

    public static ChatMessage toChatMessage(ChatMessageEntity chatMessageEntity) {
        return new ChatMessage(chatMessageEntity.getText());
    }

    public static List<ChatMessage> toChatMessages(Iterable<ChatMessageEntity> chatMessageEntities) {
        return StreamSupport.stream(chatMessageEntities.spliterator(), false)
                .map(ChatMessageEntityMapper::toChatMessage)
                .collect(Collectors.toList());
    }
}
