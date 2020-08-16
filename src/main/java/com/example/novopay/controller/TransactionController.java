package com.example.novopay.controller;

import com.example.novopay.dto.PaymentTransferDto;
import com.example.novopay.service.TransactionService;
import com.example.novopay.utils.PayResponse;
import com.example.novopay.utils.PaymentType;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/payment")
    public PayResponse makePayment(@RequestBody PaymentTransferDto paymentTransferDto){
        return transactionService.makePayment(paymentTransferDto);
    }

    @GetMapping("/status")
    public PayResponse getStatus(@RequestParam("transactionId") Long transactionId){
        return transactionService.getStatus(transactionId);
    }

    @PostMapping("/reversal")
    public PayResponse reverseTransaction(@RequestBody Long transactionId){
        return transactionService.reverseTransaction(transactionId);
    }

    @GetMapping("/all")
    public PayResponse getAllTransaction(@RequestParam("userId") String emailId){
        return transactionService.getAllTransaction(emailId);
    }
}
