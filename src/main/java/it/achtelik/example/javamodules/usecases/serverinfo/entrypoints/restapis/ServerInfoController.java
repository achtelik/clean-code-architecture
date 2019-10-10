package it.achtelik.example.javamodules.usecases.serverinfo.entrypoints.restapis;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerInfoController {

    @GetMapping("/server-info")
    public ResponseEntity<String> getServerInfo() {
        return new ResponseEntity<>("Up", HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
