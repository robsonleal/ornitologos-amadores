package com.sicredi.ornitologosbackend.kafka;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvistamentoProducer {
    @Value("${spring.kafka.avistamento-topico.name}")
    private String topico;

    private final KafkaTemplate<String, AvistamentoDto> kafkaTemplate;

    public void enviarAvistamento(AvistamentoDto dto){

        Message<AvistamentoDto> msg = MessageBuilder
            .withPayload(dto)
            .setHeader(KafkaHeaders.TOPIC, topico)
            .build();

        kafkaTemplate.send(msg);
    }
}
