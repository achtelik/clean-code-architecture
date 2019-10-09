package it.achtelik.example.javamodules.usecases.chat;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    @GetMapping("/chat")
    public ResponseEntity<List<String>> getServerInfo() {
        return new ResponseEntity<String>(, HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
