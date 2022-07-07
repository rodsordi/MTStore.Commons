package br.com.mt.store.commons.infra.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

@Slf4j
public abstract class KafkaListener<T> extends KafkaComponent {
    private final KafkaConsumer<String, T> kafkaConsumer;

    public KafkaListener(Properties properties, String topic) {
        kafkaConsumer = new KafkaConsumer<>(handleProperties(properties));
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    public KafkaListener(Properties properties, Pattern pattern) {
        kafkaConsumer = new KafkaConsumer<>(handleProperties(properties));
        kafkaConsumer.subscribe(pattern);
    }

    protected abstract Class<T> getType();

    public void listen() {
        while (true) {
            var records = kafkaConsumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                log.info("Encontrado {} registros", records.count());
                for (var record : records) {
                    log.info("#################################");
                    log.info("Processando");
                    log.info("Record Key: {}", record.key());
                    log.info("Record Value: {}", record.value());
                }
            }
        }
    }

    @Override
    protected Properties commonsProperties() {
        Properties commonsProperties = new Properties();
        commonsProperties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        commonsProperties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DeserializerGson.class.getName());
        commonsProperties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, getClass().getSimpleName() + "_" + UUID.randomUUID());
        commonsProperties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        commonsProperties.setProperty(DeserializerGson.TYPE_CONFIG, getType().getName());
        return commonsProperties;
    }
}
