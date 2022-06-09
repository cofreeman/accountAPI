package com.nhnacademy.accountApi.repository;


import com.nhnacademy.accountApi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
