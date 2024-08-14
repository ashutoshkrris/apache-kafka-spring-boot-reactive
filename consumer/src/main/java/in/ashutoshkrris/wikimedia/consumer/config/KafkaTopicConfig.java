package in.ashutoshkrris.wikimedia.consumer.config;

import in.ashutoshkrris.wikimedia.consumer.constants.Constants;
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
