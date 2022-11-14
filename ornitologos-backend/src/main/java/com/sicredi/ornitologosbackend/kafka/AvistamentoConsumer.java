package com.sicredi.ornitologosbackend.kafka;

import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvistamentoConsumer {

    private final AvistamentoRepository avistamentoRepository;
    private  final ModelMapper modelMapper;

    @KafkaListener(topics = "${spring.kafka.avistamento-topico.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void persistirAvistamento(AvistamentoDto dto) {

        Avistamento entity = modelMapper.map(dto,Avistamento.class);

        avistamentoRepository.save(entity);
    }
}
