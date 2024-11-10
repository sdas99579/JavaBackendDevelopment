package org.gfg.minor1.controller;

import jakarta.validation.Valid;
import org.gfg.minor1.exception.TxnException;
import org.gfg.minor1.model.Book;
import org.gfg.minor1.request.BookCreateRequest;
import org.gfg.minor1.request.TxnCreateRequest;
import org.gfg.minor1.request.TxnReturnRequest;
import org.gfg.minor1.response.GenericResponse;
import org.gfg.minor1.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse<String>> createTxn(@RequestBody @Valid TxnCreateRequest txnCreateRequest) throws TxnException {
        String txnid =  txnService.create(txnCreateRequest);
        GenericResponse<String> response = new GenericResponse<>(txnid,"","success","200");

        ResponseEntity entity = new ResponseEntity<>(response, HttpStatus.OK);

        return entity;


    }

    @PutMapping("/return")
    public int returnTxn(@RequestBody TxnReturnRequest txnReturnRequest) throws TxnException {
        return txnService.returnBook(txnReturnRequest);
    }
}
