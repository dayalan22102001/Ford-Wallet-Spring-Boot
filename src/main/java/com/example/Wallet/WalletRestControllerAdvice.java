package com.example.Wallet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletRestControllerAdvice {

    @ExceptionHandler(WalletException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleWalletException(WalletException e){
       return e.getMessage();
    }

}
