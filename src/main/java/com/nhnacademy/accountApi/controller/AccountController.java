package com.nhnacademy.accountApi.controller;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.repository.AccountRepository;
import com.nhnacademy.accountApi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    //note return = responseEntity. responseEntity = header + body 
    private final AccountService accountService;

    //note restTemplate 에는 requestHeader + requestBody 가 담겨져 오니까 매개변수로 @RequestBody를 받는다.
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequestDto accountRequestDto) {

        //note 자바객체를 json 으로 변경
        Account account = accountService.createAccount(accountRequestDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .headers(httpHeaders)
                .body(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {

        Account account = accountService.findAccount(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {

        List<Account> accounts = accountService.findAccounts();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(accounts);
    }

    //note patch 매핑
    @PostMapping("/{id}")
    public ResponseEntity<Account> modifyAccount(@PathVariable("id") Long id,
                                                 @RequestBody AccountRequestDto accountRequestDto) {

        Account account = accountService.modifyAccount(id, accountRequestDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }

    @GetMapping("/{id}/join")
    public ResponseEntity<Account> modifyAccountStateJoin(@PathVariable("id") Long id) {

        Account account = accountService.modifyAccountStateJoin(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }
    @GetMapping("/{id}/deleted")
    public ResponseEntity<Account> modifyAccountStateDeleted(@PathVariable("id") Long id) {

        Account account = accountService.modifyAccountStateDeleted(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }
    @GetMapping("/{id}/resting")
    public ResponseEntity<Account> modifyAccountStateResting(@PathVariable("id") Long id) {

        Account account = accountService.modifyAccountStateResting(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }

}
