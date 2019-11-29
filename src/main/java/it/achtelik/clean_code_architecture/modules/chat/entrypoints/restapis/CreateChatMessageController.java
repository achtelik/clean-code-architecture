package it.achtelik.clean_code_architecture.modules.chat.entrypoints.restapis;

import it.achtelik.clean_code_architecture.modules.chat.domain.usecases.CreateChatMessageUseCase;
import it.achtelik.clean_code_architecture.modules.chat.entrypoints.mappers.ChatMessageDtoMapper;
import it.achtelik.clean_code_architecture.modules.chat.entrypoints.models.ChatMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateChatMessageController {

    private final CreateChatMessageUseCase createChatMessageUseCase;

    public CreateChatMessageController(CreateChatMessageUseCase createChatMessageUseCase) {
        this.createChatMessageUseCase = createChatMessageUseCase;
    }

    @PutMapping("/chat")
    public ResponseEntity<ChatMessageDto> createChatMessage(@RequestBody ChatMessageDto message) {
        return new ResponseEntity<>(ChatMessageDtoMapper.fromChatMessage(
                createChatMessageUseCase.createChatMessage(ChatMessageDtoMapper.toChatMessage(message))),
                HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
