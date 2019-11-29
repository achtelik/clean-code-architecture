package it.achtelik.clean_code_architecture.modules.chat.domain.usecases;

import it.achtelik.clean_code_architecture.modules.chat.dataproviders.db.ports.SaveChatMessageRepositoryPort;
import it.achtelik.clean_code_architecture.modules.chat.domain.models.ChatMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CreateChatMessageUseCaseTest {

    private SaveChatMessageRepositoryPort saveChatMessageRepositoryPortMock;
    private CreateChatMessageUseCase createChatMessageUseCase;

    @Before
    public void setUp() {
        saveChatMessageRepositoryPortMock = Mockito.mock(SaveChatMessageRepositoryPort.class);
        createChatMessageUseCase = new CreateChatMessageUseCase(saveChatMessageRepositoryPortMock);
    }

    @Test
    public void createChatMessage() {
        Mockito.when(saveChatMessageRepositoryPortMock.save(Mockito.any())).thenReturn(new ChatMessage("Dud mocked"));
        Assert.assertEquals("Dud mocked", createChatMessageUseCase.createChatMessage(new ChatMessage("DUD")).getText());
    }
}
