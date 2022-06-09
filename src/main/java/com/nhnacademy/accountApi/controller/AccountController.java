package com.nhnacademy.accountApi.controller;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.dto.AccountResponseDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountController {

    //note return = responseEntity. responseEntity = header + body 
    private final AccountService accountService;


    //note restTemplate 에는 requestHeader + requestBody 가 담겨져 오니까 매개변수로 @RequestBody를 받는다.
    //todo 회원 추가
    @PostMapping("/accounts")
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto accountRequestDto) {

        Account account = accountService.createAccount(accountRequestDto);

//        return ResponseEntity.
//                status(HttpStatus.OK).
//                headers().
//                contentType(MediaType.APPLICATION_JSON).
//                body();

        return null;
    }

    //todo 회원 조회
    @GetMapping("/accounts/{id}")
    public String getAccount(@PathVariable("id") Long id) {
        //fixme: id 값 검증 하자!

        //todo: Qdsl custom
        Optional<Account> account = accountService.findAccount(id);

        return null;
    }

    //todo 회원전체 조회
    @GetMapping("/accounts")
    public String getAccounts() {

        List<Optional<Account>> accounts = accountService.findAccounts();

        return null;
    }

    //todo 회원 수정
    //note patch 매핑
    @PutMapping("/accounts/{id}")
    public String modifyAccount(@PathVariable("id") Long id,
                                @RequestBody AccountRequestDto accountRequestDto) {

        Account account = accountService.modifyAccount(id);
        return null;
    }

    //todo 회원 삭제
    @PostMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return null;
    }
}
