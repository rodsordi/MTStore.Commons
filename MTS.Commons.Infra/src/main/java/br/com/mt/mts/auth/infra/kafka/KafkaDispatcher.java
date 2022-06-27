package br.com.mt.mts.auth.infra.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public abstract class KafkaDispatcher<T> implements Closeable {
    private final Topic topic;

    private KafkaProducer kafkaProducer;
    private Callback callback;

    protected abstract String getChave(T t);

    public KafkaDispatcher(Properties properties, Topic topic) {
        this.topic = topic;
        kafkaProducer = new KafkaProducer<String, String>(handleProperties(properties));
        prepareCallback();
    }

    private Properties handleProperties(Properties externalProperties) {
        Properties commonsProperties = new Properties();
        commonsProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        commonsProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SerializerGson.class.getName());
        commonsProperties.putAll(externalProperties);
        return commonsProperties;
    }

    private void prepareCallback() {
        callback = (data, e) -> {
            if (e != null) {
                log.error(e.getMessage());
                return;
            }
            log.info("Enviada msg topico: {}, partition: {}, offset: {}",
                    data.topic(),
                    data.partition(),
                    data.offset());
        };
    }

    public void enviar(T mensagem) throws ExecutionException, InterruptedException {
        kafkaProducer.send(new ProducerRecord<>(topic.name(), getChave(mensagem), mensagem), callback).get();
    }

    @Override
    public void close() {
        kafkaProducer.close();
    }

}
