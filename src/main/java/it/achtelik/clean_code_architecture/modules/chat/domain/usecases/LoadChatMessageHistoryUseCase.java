package it.achtelik.clean_code_architecture.modules.chat.domain.usecases;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports.FindAllChatMessageRepositoryPort;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;

import java.util.List;

public class LoadChatMessageHistoryUseCase {
    FindAllChatMessageRepositoryPort chatMessageRepositoryPort;

    public LoadChatMessageHistoryUseCase(FindAllChatMessageRepositoryPort chatMessageRepositoryPort) {
        this.chatMessageRepositoryPort = chatMessageRepositoryPort;
    }

    public List<ChatMessage> loadChatMessageHistory() {
        return chatMessageRepositoryPort.findAll();
    }
}
