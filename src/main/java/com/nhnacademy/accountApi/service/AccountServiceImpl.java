package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(AccountRequestDto accountRequestDto) {

        accountRepository.insert(accountRequestDto);
        return null;
    }

    @Override
    public Optional<Account> findAccount(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Optional<Account>> findAccounts() {
        return null;
    }

    @Override
    public Account modifyAccount(Long id) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }
}
