package br.com.challenge.picpay.Desafio.Picpay.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.challenge.picpay.Desafio.Picpay.dto.ErrorDTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExcepitonHandler {
    


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> error404(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> error400(MethodArgumentNotValidException e){
        FieldError error = e.getFieldError();
        return new ResponseEntity<>(new ErrorDTO(error),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> errorGeneral(Exception e){
        return new ResponseEntity<>(new ErrorDTO(e),HttpStatus.BAD_REQUEST);
    }



}
