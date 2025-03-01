package com.padrao.mvc.mvc.models.product.exceptions;

public class ProductNullNameException extends RuntimeException{
    public ProductNullNameException(){
        super("O nome do produto não pode ser vazio.");
        printStackTrace();
    }
}
