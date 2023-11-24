package br.com.challenge.picpay.Desafio.Picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.picpay.Desafio.Picpay.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findUserById(Long id);

    Optional<User> findUserByDocument(String document);
    
}
