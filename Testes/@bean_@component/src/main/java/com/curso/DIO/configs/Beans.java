package com.curso.DIO.configs;

import com.curso.DIO.entities.EmailEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Value("${AUTOR}")
    private String autor;
    @Value("${MENSAGEM}")
    private String mensagem;

    @Bean
    public EmailEntity emailEntity(){
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.autor=autor;
        emailEntity.mensagem=mensagem;
        return emailEntity;
    }

}
