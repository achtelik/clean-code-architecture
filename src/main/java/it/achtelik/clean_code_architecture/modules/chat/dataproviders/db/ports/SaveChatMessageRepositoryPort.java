package it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.entities.ChatMessageEntity;
import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.mappers.ChatMessageEntityMapper;
import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.repos.ChatMessageRepository;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class SaveChatMessageRepositoryPort {
    private final ChatMessageRepository chatMessageRepository;

    public SaveChatMessageRepositoryPort(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage save(ChatMessage chatMessage) {
        ChatMessageEntity chatMessageEntity = ChatMessageEntityMapper.fromChatMessage(chatMessage);
        if (chatMessageEntity.getId() == null) {
            chatMessageEntity.setCreateDate(Instant.now());
        }
        chatMessageEntity.setLastModifiedDate(Instant.now());

        chatMessageEntity = chatMessageRepository.save(
                chatMessageEntity);

        return ChatMessageEntityMapper.toChatMessage(chatMessageEntity);
    }

    public List<ChatMessage> findAll() {
        return ChatMessageEntityMapper.toChatMessages(chatMessageRepository.findAll(PageRequest.of(0, 20, Sort.by("createDate").descending())));
    }
}
