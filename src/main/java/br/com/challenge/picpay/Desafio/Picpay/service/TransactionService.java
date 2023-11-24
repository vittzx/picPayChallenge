package br.com.challenge.picpay.Desafio.Picpay.service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import br.com.challenge.picpay.Desafio.Picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.Desafio.Picpay.domain.user.User;
import br.com.challenge.picpay.Desafio.Picpay.dto.MessageBodyAuthorizationDTO;
import br.com.challenge.picpay.Desafio.Picpay.dto.TransactionDTO;
import br.com.challenge.picpay.Desafio.Picpay.repository.TransactionRepository;
import jakarta.validation.Valid;

@Service
public class TransactionService {
    
    private final String urlAuthorizeTransaction = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";

    @Autowired
    private UserService userService;


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Transaction createTransaction(@RequestBody @Valid TransactionDTO data) throws Exception{

        User sender = userService.findUserById(data.idSender());
        User receiver = userService.findUserById(data.idReceiver());

        userService.validateTransacion(sender, data.amount());
        
        Boolean isAuthorized = authorizeTransaction();
        if(!isAuthorized) throw new Exception("Transação nao autorizada!");

        Transaction newTransaction = new Transaction();

        
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setAmount(data.amount());
        newTransaction.setTimeStamp(timeNow());

        sender.setBalance(sender.getBalance().subtract(data.amount()));
        receiver.setBalance(receiver.getBalance().add(data.amount()));
        
        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;
    }


    private boolean authorizeTransaction(){
        ResponseEntity<MessageBodyAuthorizationDTO> messageDTO = restTemplate.getForEntity(urlAuthorizeTransaction, MessageBodyAuthorizationDTO.class);
        String message = messageDTO.getBody().message();

        if(messageDTO.getStatusCode() == HttpStatus.OK){
            return "Autorizado".equals(message);
        }
        return false;
    }

    private LocalDateTime timeNow(){
        return LocalDateTime.now();
    }

}
