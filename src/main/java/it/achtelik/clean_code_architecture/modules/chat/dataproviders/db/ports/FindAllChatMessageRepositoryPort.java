package it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.mappers.ChatMessageEntityMapper;
import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.repos.ChatMessageRepository;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllChatMessageRepositoryPort {
    private final ChatMessageRepository chatMessageRepository;

    public FindAllChatMessageRepositoryPort(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessage> findAll() {
        return ChatMessageEntityMapper.toChatMessages(chatMessageRepository.findAll(
                PageRequest.of(0, 20, Sort.by("createDate").descending())));
    }
}
