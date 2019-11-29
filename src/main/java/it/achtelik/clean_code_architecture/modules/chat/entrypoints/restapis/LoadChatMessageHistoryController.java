package it.achtelik.clean_code_architecture.modules.chat.entrypoints.restapis;

import it.achtelik.clean_code_architecture.modules.chat.domain.usecases.LoadChatMessageHistoryUseCase;
import it.achtelik.clean_code_architecture.modules.chat.entrypoints.mappers.ChatMessageDtoMapper;
import it.achtelik.clean_code_architecture.modules.chat.entrypoints.models.ChatMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoadChatMessageHistoryController {

    private final LoadChatMessageHistoryUseCase loadChatMessageHistoryUseCase;

    public LoadChatMessageHistoryController(LoadChatMessageHistoryUseCase loadChatMessageHistoryUseCase) {
        this.loadChatMessageHistoryUseCase = loadChatMessageHistoryUseCase;
    }

    @GetMapping("/chat")
    public ResponseEntity<List<ChatMessageDto>> loadChatMessageHistory() {
        return new ResponseEntity<>(ChatMessageDtoMapper.fromChatMessages(loadChatMessageHistoryUseCase.loadChatMessageHistory()),
                HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
