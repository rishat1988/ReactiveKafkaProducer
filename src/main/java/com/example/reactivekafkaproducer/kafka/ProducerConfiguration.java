package org.crm.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.security.plain.PlainLoginModule;
import org.apache.kafka.common.serialization.StringSerializer;
import org.crm.kafka.model.CaseDeleteKafkaModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    private static final String SECURITY_PROTOCOL_CONFIG_VALUE = "SASL_PLAINTEXT";
    private static final String SASL_MECHANISM_CONFIG_VALUE = "PLAIN";
    private static final String AUTHENTICATION_FORMAT = "%s required username=\"%s\" password=\"%s\";";

    @Value("${kafka.login}")
    private String login;

    @Value("${kafka.password}")
    private String password;

    @Value("${kafka.bootstrap-servers}")
    private String socketServiceServer;

    @Value("${kafka.request-timeout}")
    private int requestTimeout;

    @Bean
    public ReactiveKafkaProducerTemplate<String, CaseDeleteKafkaModel> reactiveKafkaProducerTemplate(KafkaProperties kafkaProperties) {
        Map<String, Object> properties = kafkaProperties.buildProducerProperties();
        properties.putAll(prepareProducerParamsMap());
        return new ReactiveKafkaProducerTemplate<>(SenderOptions.create(properties));
    }

    private Map<String, Object> prepareProducerParamsMap() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, socketServiceServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeout);
        config.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL_CONFIG_VALUE);
        config.put(SaslConfigs.SASL_MECHANISM, SASL_MECHANISM_CONFIG_VALUE);
        config.put(SaslConfigs.SASL_JAAS_CONFIG, String.format(AUTHENTICATION_FORMAT,
                PlainLoginModule.class.getName(), login, password));
        return config;
    }
}
