package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.dto.AccountResponseDto;
import com.nhnacademy.accountApi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(AccountRequestDto accountRequestDto);

가    Account findAccount(Long id);

    List<Account> findAccounts();

    Account modifyAccount(Long id,AccountRequestDto accountRequestDto);

    void deleteAccount(Long id);
}
