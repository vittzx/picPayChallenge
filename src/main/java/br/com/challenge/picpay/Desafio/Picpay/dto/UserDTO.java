package br.com.challenge.picpay.Desafio.Picpay.dto;

import java.math.BigDecimal;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotBlank(message = "Primeiro nome é obrigatirio") String firstName,
                      @NotBlank(message = "Ulitmo nome é obrigatorio") String lastName,
                      @NotBlank(message = "Email na formatacao tipo email é obrigatorio") @Email String email,
                      @NotBlank(message = "CPF/CNPJ é obrigatorio") String document,
                      @NotBlank(message = "SENHA é obrigatorio") String password,
                      @NotNull(message = "Saldo é obrigatorio") BigDecimal balance,
                      @NotNull(message = "Tipo do usuario é Obrigatorio: COMMON/MERCHANT") UserType userType) {
    
}
