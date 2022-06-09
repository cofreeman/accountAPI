package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.dto.AccountResponseDto;
import com.nhnacademy.accountApi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(AccountRequestDto accountRequestDto);

    Optional<Account> findAccount(Long id);

    List<Optional<Account>> findAccounts();

    Account modifyAccount(Long id);

    void deleteAccount(Long id);
}
