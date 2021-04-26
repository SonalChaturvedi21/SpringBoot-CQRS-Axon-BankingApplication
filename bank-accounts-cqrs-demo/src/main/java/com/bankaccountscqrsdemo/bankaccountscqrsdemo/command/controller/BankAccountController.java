package com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.controller;

import com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.dto.CreateAccountRequest;
import com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.dto.DepositRequest;
import com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.dto.WithdrawalRequest;
import com.bankaccountscqrsdemo.bankaccountscqrsdemo.command.service.AccountCommandService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {

    private final AccountCommandService accountCommandService;

    public BankAccountController(AccountCommandService accountCommandService){
        this.accountCommandService=accountCommandService;
    }

    @PostMapping(value="/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request) {
        try{
            CompletableFuture<String> response = accountCommandService.createAccount(request);
            return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequest request){
        try{
            CompletableFuture<String> response = accountCommandService.depositToAccount(request);
            return new ResponseEntity<>("Amount credited",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawalRequest request){
        try{
            CompletableFuture<String> response = accountCommandService.withdrawFromAccount(request);
            return new ResponseEntity<>("Amount Debited",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}