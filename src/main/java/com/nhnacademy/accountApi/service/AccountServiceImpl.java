package com.nhnacademy.accountApi.service;

import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.entity.AccountState;
import com.nhnacademy.accountApi.exception.NotFoundAccountException;
import com.nhnacademy.accountApi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    //todo: AccountResponseDto를 반환
    @Transactional
    @Override
    public Account createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();

        account.setEmail(accountRequestDto.getEmail());
        account.setId(accountRequestDto.getId());
        account.setPassword(accountRequestDto.getPassword());
        account.setState(AccountState.JOIN);

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
    @Transactional
    public Account modifyAccount(Long id, AccountRequestDto accountRequestDto) {

        Account account = accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);

        account.setEmail(accountRequestDto.getEmail());
        account.setId(accountRequestDto.getId());
        account.setPassword(accountRequestDto.getPassword());

        return accountRepository.save(account);
    }

    @Override
    public Account modifyAccountStateJoin(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);
        account.setState(AccountState.JOIN);
        return accountRepository.save(account);
    }

    @Override
    public Account modifyAccountStateDeleted(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);
        account.setState(AccountState.DELETED);
        return accountRepository.save(account);
    }

    @Override
    public Account modifyAccountStateResting(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(NotFoundAccountException::new);
        account.setState(AccountState.RESTING);
        return accountRepository.save(account);
    }
}
