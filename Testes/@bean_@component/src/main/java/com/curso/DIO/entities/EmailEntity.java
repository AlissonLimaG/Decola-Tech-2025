package com.curso.DIO.entities;

import org.springframework.stereotype.Component;

@Component
public class EmailEntity {

    public String mensagem;
    public String autor;

    public EmailEntity(String mensagem, String autor) {
        this.mensagem = mensagem;
        this.autor = autor;
    }

    public EmailEntity() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
