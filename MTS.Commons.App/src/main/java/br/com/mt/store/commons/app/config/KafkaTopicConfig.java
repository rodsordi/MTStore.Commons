package br.com.mt.store.commons.app.config;

import br.com.mt.store.commons.infra.kafka.Topic;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrapServers}")
    private String bootstrapServer;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        return new KafkaAdmin(configs);
    }

    /*@Bean
    public NewTopic authentication() {
        return new NewTopic(Topic.MTS_AUTH_USER_AUTHENTICATION, 3, (short) 3);
    }*/

    @Bean
    public NewTopic userCreation() {
        return new NewTopic(Topic.MTS_USER_CREATION, 3, (short) 3);
    }

    @Bean
    public NewTopic userPasswordReset() {
        return new NewTopic(Topic.MTS_USER_PASSWORD_RESET, 3, (short) 3);
    }

}
