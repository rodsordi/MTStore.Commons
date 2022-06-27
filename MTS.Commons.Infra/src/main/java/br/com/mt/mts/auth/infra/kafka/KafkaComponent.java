package br.com.mt.mts.auth.infra.kafka;

import java.util.Properties;

public abstract class KafkaComponent {

    protected abstract Properties commonsProperties();

    protected Properties handleProperties(Properties externalProperties) {
        Properties properties = commonsProperties();
        properties.putAll(overrideCommonsProperties());
        properties.putAll(externalProperties);
        return properties;
    }

    protected Properties overrideCommonsProperties() {
        return new Properties();
    }

}
