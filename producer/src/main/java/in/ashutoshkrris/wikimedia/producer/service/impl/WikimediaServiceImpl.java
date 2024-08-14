package in.ashutoshkrris.wikimedia.producer.service.impl;

import in.ashutoshkrris.wikimedia.producer.producer.KafkaProducer;
import in.ashutoshkrris.wikimedia.producer.service.WikimediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaServiceImpl implements WikimediaService {

    private final WebClient webClient;

    private final KafkaProducer kafkaProducer;

    public WikimediaServiceImpl(WebClient.Builder webClientBuilder, KafkaProducer kafkaProducer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this.kafkaProducer = kafkaProducer;
    }


    @Override
    public void consumeStreamAndPublish() {
        log.info("consumeStreamAndPublish::Received request to consume stream and publish");
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(kafkaProducer::sendMessage);
    }
}
