package com.nhnacademy.accountApi.controller;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
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
    //todo 회원 추가
    @Transactional
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

    //todo 회원 조회
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        //fixme: id 값 검증 하자!

        //todo: Qdsl custom
        Account account = accountService.findAccount(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }

    //todo 회원전체 조회
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

    //todo 회원 수정
    //note patch 매핑
    @Transactional
    @PutMapping("/{id}")
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

//    //todo 회원 삭제
//    @Transactional
//    @PostMapping("/{id}")
//    public ResponseEntity<Account> deleteAccount(@PathVariable("id") Long id) {
//        Account account = accountService.deleteAccount(id);
//
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .headers(httpHeaders)
//                .body(account);
//    }
}
