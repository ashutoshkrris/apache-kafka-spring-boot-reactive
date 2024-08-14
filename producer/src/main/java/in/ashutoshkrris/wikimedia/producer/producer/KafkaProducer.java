package in.ashutoshkrris.wikimedia.producer.producer;

import in.ashutoshkrris.wikimedia.producer.constants.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info("sendMessage::Sending message to topic={}", Constants.WIKIMEDIA_TOPIC);
        kafkaTemplate.send(Constants.WIKIMEDIA_TOPIC, msg);
    }
}
