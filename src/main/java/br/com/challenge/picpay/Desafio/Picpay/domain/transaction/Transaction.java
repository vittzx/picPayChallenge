package br.com.challenge.picpay.Desafio.Picpay.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne // usuarios ppode ter varias transacoes, porem 1 transacao so pode 1 sender e 1 receiver
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    private User receiver;

    private LocalDateTime timeStamp;
    
}
