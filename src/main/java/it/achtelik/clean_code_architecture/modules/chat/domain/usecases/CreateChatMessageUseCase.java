package it.achtelik.clean_code_architecture.modules.chat.domain.usecases;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports.SaveChatMessageRepositoryPort;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;

public class CreateChatMessageUseCase {

    private final SaveChatMessageRepositoryPort saveChatMessageRepositoryPort;

    public CreateChatMessageUseCase(SaveChatMessageRepositoryPort saveChatMessageRepositoryPort) {
        this.saveChatMessageRepositoryPort = saveChatMessageRepositoryPort;
    }

    public ChatMessage createChatMessage(ChatMessage message) {
        return saveChatMessageRepositoryPort.save(message);
    }
}
