package com.sicredi.ornitologosbackend.configs;

import com.sicredi.ornitologosbackend.dtos.AveDto;
import com.sicredi.ornitologosbackend.dtos.AvistamentoDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioCadastroDto;
import com.sicredi.ornitologosbackend.dtos.UsuarioDto;
import com.sicredi.ornitologosbackend.entities.Ave;
import com.sicredi.ornitologosbackend.entities.Avistamento;
import com.sicredi.ornitologosbackend.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper= new ModelMapper();

        modelMapper.createTypeMap(Usuario.class, UsuarioDto.class);
        modelMapper.createTypeMap(UsuarioDto.class, Usuario.class);
        modelMapper.createTypeMap(UsuarioCadastroDto.class, Usuario.class);
        modelMapper.createTypeMap(AvistamentoDto.class, Avistamento.class);
        modelMapper.createTypeMap(AveDto.class, Ave.class);
        modelMapper.createTypeMap(Ave.class, AveDto.class);


        return  modelMapper;
    }
}
