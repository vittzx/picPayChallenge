package br.com.challenge.picpay.Desafio.Picpay.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record TransactionDTO(@NotNull Long idSender, @NotNull Long idReceiver, @NotNull BigDecimal amount) {
    
}
