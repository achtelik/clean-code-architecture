package it.achtelik.clean_code_architecture.modules.chat;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports.FindAllChatMessageRepositoryPort;
import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports.SaveChatMessageRepositoryPort;
import it.achtelik.clean_code_architecture.modules.chat.domain.usecases.CreateChatMessageUseCase;
import it.achtelik.clean_code_architecture.modules.chat.domain.usecases.LoadChatMessageHistoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfiguration {

    @Bean
    public CreateChatMessageUseCase createChatMessageUseCase(SaveChatMessageRepositoryPort saveChatMessageRepositoryPort) {
        return new CreateChatMessageUseCase(saveChatMessageRepositoryPort);
    }

    @Bean
    public LoadChatMessageHistoryUseCase loadChatMessageHistoryUseCase(
            FindAllChatMessageRepositoryPort findAllChatMessageRepositoryPort) {
        return new LoadChatMessageHistoryUseCase(findAllChatMessageRepositoryPort);
    }
}
