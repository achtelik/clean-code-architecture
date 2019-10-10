package it.achtelik.example.javamodules.usecases.chat.entrypoints.restapis;

import it.achtelik.example.javamodules.usecases.chat.domain.services.ChatService;
import it.achtelik.example.javamodules.usecases.chat.entrypoints.mappers.ChatMessageDtoMapper;
import it.achtelik.example.javamodules.usecases.chat.entrypoints.models.ChatMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private final ChatService chatService = new ChatService();

    @PutMapping("/chat")
    public ResponseEntity<Boolean> putMessage(@RequestBody ChatMessageDto message) {
        return new ResponseEntity<>(chatService.saveMessage(ChatMessageDtoMapper.toChatMessage(message)),
                HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @GetMapping("/chat")
    public ResponseEntity<List<ChatMessageDto>> getMessages() {
        return new ResponseEntity<>(ChatMessageDtoMapper.fromChatMessages(chatService.loadMessages()),
                HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
