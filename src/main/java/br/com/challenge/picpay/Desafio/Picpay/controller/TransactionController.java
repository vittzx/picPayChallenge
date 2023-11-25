package br.com.challenge.picpay.Desafio.Picpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.picpay.Desafio.Picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.Desafio.Picpay.dto.TransactionDTO;
import br.com.challenge.picpay.Desafio.Picpay.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transctions = this.transactionService.findAllTransactions();
        return new ResponseEntity<>(transctions,HttpStatus.OK);
    }


    @PostMapping 
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid TransactionDTO transactionDTO) throws Exception{
        Transaction transaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(transaction,HttpStatus.CREATED);
    }


}
