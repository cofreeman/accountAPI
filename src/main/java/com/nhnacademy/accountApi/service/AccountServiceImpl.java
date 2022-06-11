package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.entity.AccountState;
import com.nhnacademy.accountApi.exception.NotFoundAccountException;
import com.nhnacademy.accountApi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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
        account.setState(accountRequestDto.getState());

        return accountRepository.save(account);

    }

    @Override
    public Account findAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);

    }

    @Override
    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account modifyAccount(Long id, AccountRequestDto accountRequestDto) {

        Account account = accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);

        account.setEmail(accountRequestDto.getEmail());
        account.setId(accountRequestDto.getId());
        account.setPassword(accountRequestDto.getPassword());
        account.setState(accountRequestDto.getState());

        return accountRepository.save(account);

    }
}
