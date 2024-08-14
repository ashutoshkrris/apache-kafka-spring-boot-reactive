package in.ashutoshkrris.wikimedia.producer.controller;

import in.ashutoshkrris.wikimedia.producer.service.impl.WikimediaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {

    private final WikimediaServiceImpl wikimediaService;

    @GetMapping
    public ResponseEntity<String> publishStreams() {
        wikimediaService.consumeStreamAndPublish();
        return ResponseEntity.ok("Started consuming and publishing...");
    }

}
