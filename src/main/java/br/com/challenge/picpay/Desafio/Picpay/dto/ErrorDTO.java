package br.com.challenge.picpay.Desafio.Picpay.dto;

import org.springframework.validation.FieldError;

public record ErrorDTO(String field, String message) {
    public ErrorDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }

    public ErrorDTO(Exception e){
        this("400 bad request", e.getMessage());
    }
}
