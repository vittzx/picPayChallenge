package br.com.challenge.picpay.Desafio.Picpay.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.User;
import br.com.challenge.picpay.Desafio.Picpay.domain.user.UserType;
import br.com.challenge.picpay.Desafio.Picpay.dto.UserDTO;
import br.com.challenge.picpay.Desafio.Picpay.repository.UserRepository;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransacion(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo LOJISTA nao pode realizar transferencias!");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Usuario nao tem saldo suficiente!");
        }
    }

    
    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public void saveUser(User user){ this.userRepository.save(user); }

    public List<User> findAllUsers() { return this.userRepository.findAll(); }

    public User createUser(UserDTO userDTO){
        User user = new User(userDTO);
        this.userRepository.save(user); // saving in the db
        return user;
    }




}
