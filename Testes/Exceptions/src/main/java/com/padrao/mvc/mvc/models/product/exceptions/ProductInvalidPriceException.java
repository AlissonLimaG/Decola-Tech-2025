package com.padrao.mvc.mvc.models.product.exceptions;

public class ProductInvalidPriceException extends RuntimeException{
    public ProductInvalidPriceException(){
        super("Valor inserido é inválido!");
        printStackTrace();
    }
}
