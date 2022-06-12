package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountRequestDto accountRequestDto);

    Account findAccount(Long id);

    List<Account> findAccounts();

    Account modifyAccount(Long id, AccountRequestDto accountRequestDto);

    Account modifyAccountStateJoin(Long id);

    Account modifyAccountStateDeleted(Long id);

    Account modifyAccountStateResting(Long id);
}
