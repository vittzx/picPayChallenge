package br.com.challenge.picpay.Desafio.Picpay.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record TransactionDTO(
 
 @NotNull(message = "id do Remetente é obrigatorio")
 Long idSender, 

 @NotNull(message = "id do Destinatario é obrigatorio") 
 Long idReceiver, 

 @NotNull(message = "quantia é obrigatoria") 
 BigDecimal amount) {
    
}
