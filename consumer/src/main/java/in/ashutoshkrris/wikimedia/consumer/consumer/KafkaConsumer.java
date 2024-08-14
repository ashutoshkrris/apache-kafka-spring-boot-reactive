package in.ashutoshkrris.wikimedia.consumer.consumer;

import in.ashutoshkrris.wikimedia.consumer.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = Constants.WIKIMEDIA_TOPIC, groupId = "wikimediaGroup")
    public void consumeMessage(String msg) {
        log.info("Consuming the message from {} topic, message={}", Constants.WIKIMEDIA_TOPIC, msg);
    }

}
