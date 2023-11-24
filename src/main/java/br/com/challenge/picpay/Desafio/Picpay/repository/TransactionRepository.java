package br.com.challenge.picpay.Desafio.Picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.picpay.Desafio.Picpay.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    Optional<Transaction> findTransactionById(Long id);
}
