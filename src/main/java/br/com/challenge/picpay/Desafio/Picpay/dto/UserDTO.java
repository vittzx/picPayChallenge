package br.com.challenge.picpay.Desafio.Picpay.dto;

import java.math.BigDecimal;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotBlank String firstName,
                      @NotBlank String lastName,
                      @NotBlank @Email String email,
                      @NotBlank String document,
                      @NotBlank String password,
                      @NotNull BigDecimal balance,
                      @NotNull UserType userType) {
    
}
