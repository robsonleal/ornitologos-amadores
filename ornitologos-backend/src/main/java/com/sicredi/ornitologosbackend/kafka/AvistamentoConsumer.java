package com.sicredi.ornitologosbackend.kafka;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AvistamentoConsumer {
    @Autowired
    private AvistamentoRepository repository;

    @KafkaListener(topics = "${spring.kafka.avistamento-topico.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void persistirAvistamento(AvistamentoDto dto) {
        Avistamento entity = new Avistamento(/*Passar atributos*/);

        repository.save(entity);
    }
}
