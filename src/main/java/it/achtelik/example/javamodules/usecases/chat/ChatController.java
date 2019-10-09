package it.achtelik.example.javamodules.usecases.chat;

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
    public ResponseEntity<Boolean> putMessage(@RequestBody ChatMessage message) {
        return new ResponseEntity<>(chatService.saveMessage(message), HttpHeaders.EMPTY, HttpStatus.OK);
    }

    @GetMapping("/chat")
    public ResponseEntity<List<ChatMessage>> getMessages() {
        return new ResponseEntity<>(chatService.loadMessages(), HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
