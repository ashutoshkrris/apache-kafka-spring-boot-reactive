package in.ashutoshkrris.wikimedia.producer.config;

import in.ashutoshkrris.wikimedia.producer.constants.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic wikimediaTopic() {
        return TopicBuilder.name(Constants.WIKIMEDIA_TOPIC).build();
    }

}
