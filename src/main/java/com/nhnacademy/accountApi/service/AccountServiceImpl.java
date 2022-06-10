package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.dto.AccountResponseDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    //todo: AccountResponseDto를 반환
    @Override
    public Account createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();

        account.setEmail(accountRequestDto.getEmail());
        account.setId(accountRequestDto.getId());
        account.setPassword(accountRequestDto.getPassword());

//        AccountResponseDto accountResponseDto = accountRepository.save(account);
//        return accountResponseDto;
        return accountRepository.save(account);

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
