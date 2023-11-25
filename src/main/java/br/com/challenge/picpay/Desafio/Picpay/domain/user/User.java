package br.com.challenge.picpay.Desafio.Picpay.domain.user;

import java.math.BigDecimal;

import br.com.challenge.picpay.Desafio.Picpay.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    
    public User(UserDTO userDTO) {
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.email = userDTO.email();
        this.document = userDTO.document();
        this.password = userDTO.password();
        this.balance = userDTO.balance();
        this.userType = userDTO.userType();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique =true)
    private String email;

    @Column(unique = true)
    private String document;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    
}
