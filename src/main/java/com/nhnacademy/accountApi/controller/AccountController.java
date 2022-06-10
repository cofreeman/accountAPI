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
import java.util.Optional;

@RestController
//@RequestMapping("/accounts")todo: 빼기
@RequiredArgsConstructor
public class AccountController {

    //note return = responseEntity. responseEntity = header + body 
    private final AccountService accountService;

    //note restTemplate 에는 requestHeader + requestBody 가 담겨져 오니까 매개변수로 @RequestBody를 받는다.
    //todo 회원 추가
    @Transactional
    @PostMapping("/accounts")
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
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable("id") Long id) {
        //fixme: id 값 검증 하자!

        //todo: Qdsl custom
        Optional<Account> account = accountService.findAccount(id);
        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(account);
    }

    //todo 회원전체 조회
    @GetMapping("/accounts")
    public ResponseEntity<List<Optional<Account>>> getAccounts() {

        List<Optional<Account>> accounts = accountService.findAccounts();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(accounts);
    }

    //todo 회원 수정
    //note patch 매핑
    @Transactional
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> modifyAccount(@PathVariable("id") Long id,
                                                 @RequestBody AccountRequestDto accountRequestDto) {

        Optional<Account> willModifiedAccount = accountService.findAccount(id);
        if (willModifiedAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Account account = accountService.modifyAccount(id);

        account.setId(accountRequestDto.getId());
        account.setPassword(accountRequestDto.getPassword());
        account.setEmail(accountRequestDto.getEmail());
        account.setState(accountRequestDto.getState());

        accountService.
        return null;
    }

    //todo 회원 삭제
    @Transactional
    @PostMapping("/accounts/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") Long id) {
        Optional<Account> account = accountService.findAccount(id);
        if (account.isEmpty()){
            //question: 여기서 헤더 바디 안담아도 되나?
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        accountService.deleteAccount(id);
        //question: 여기도?
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
