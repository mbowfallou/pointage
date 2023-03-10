package com.groupeisi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<APIException> handlerRequestException(RequestException e){
        APIException exception = new APIException(e.getMessage(), e.getStatus(), LocalDateTime.now());
        return new  ResponseEntity<>(exception, e.getStatus());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<APIException> handlerEntityNotFoundException(EntityNotFoundException e){
        APIException exception = new APIException(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new  ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<APIException> handlerEntityAlreadyExistsException(EntityAlreadyExistsException e){
        APIException exception = new APIException(e.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now());
        return new  ResponseEntity<>(exception, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<APIException> handlerNumberFormatException(NumberFormatException e){
        APIException exception = new APIException(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new  ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<APIException> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        APIException exception = new APIException("L'entr??e fournie n'est pas valide !", HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new  ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
