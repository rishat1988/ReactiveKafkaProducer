package org.crm.kafka;

import lombok.RequiredArgsConstructor;
import org.crm.kafka.model.CaseDeleteKafkaModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.topic.case-deletion}")
    private String topic;

    private final ReactiveKafkaProducerTemplate<String, CaseDeleteKafkaModel> producerTemplate;

    public Mono<SenderResult<Void>> send(CaseDeleteKafkaModel caseDeleteKafkaModel, String key) {
        return producerTemplate.send(topic, key, caseDeleteKafkaModel);
    }
}
