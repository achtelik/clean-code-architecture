package it.achtelik.example.javamodules.usecases.chat.dataproviders.db.ports;

import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.entities.ChatMessageEntity;
import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.mappers.ChatMessageEntityMapper;
import it.achtelik.example.javamodules.usecases.chat.dataproviders.db.ports.repos.ChatMessageRepository;
import it.achtelik.example.javamodules.usecases.chat.domain.models.ChatMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatMessageRepositoryPort {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageRepositoryPort(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage save(ChatMessage chatMessage) {
        ChatMessageEntity chatMessageEntity = chatMessageRepository.save(
                ChatMessageEntityMapper.fromChatMessage(chatMessage));
        return ChatMessageEntityMapper.toChatMessage(chatMessageEntity);
    }

    public List<ChatMessage> findAll() {
        return ChatMessageEntityMapper.toChatMessages(chatMessageRepository.findAll(PageRequest.of(0, 20, Sort.by("createDate").descending())));
    }
}
