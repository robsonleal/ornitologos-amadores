package com.sicredi.ornitologosbackend.configs;

import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.repositories.AveRepository;
import com.sicredi.ornitologosbackend.repositories.AvistamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class TestAvistamento implements CommandLineRunner {

    @Autowired
    private AveRepository aveRepository;

    @Autowired
    private AvistamentoRepository avistamentoRepository;

    @Override
    public void run(String... args) throws Exception {

        aveRepository.deleteAll();
        avistamentoRepository.deleteAll();



        Ave ave = new Ave(null, "passaro", "bird", "latimbird", 121, "macho", "preto", "familiapass", "arb");

        LocalDate data = LocalDate.now();
        LocalDateTime momento = LocalDateTime.now();

        Avistamento avistamento = new Avistamento(null, data, momento, "Amazonas", ave);

        aveRepository.saveAll(Arrays.asList(ave));
        avistamentoRepository.saveAll(Arrays.asList(avistamento));

    }
}
