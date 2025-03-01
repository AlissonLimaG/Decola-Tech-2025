package com.padrao.mvc.mvc.exceptions.exceptionResponseDesign;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private int status;
    private String mensagem;
    private String timestamp;

    public ErrorResponse(int status, String mensagem){
        this.status = status;
        this.mensagem = mensagem;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

}
