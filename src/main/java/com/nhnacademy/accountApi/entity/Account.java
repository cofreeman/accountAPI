package com.nhnacademy.accountApi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Account {
    //todo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long accountId;
    private String email;
    private String password;
    private String id;
    private String state;

    public Account(Account account) {
        this.setAccountId(account.getAccountId());
        this.setId(account.getId());
        this.setEmail(account.getEmail());
        this.setPassword(account.getPassword());
        this.setPassword(account.getState());
    }


    //TODO:VALIDATION
    //CREATE TABLE `users` (
    //	`user_id`	bigint	NOT NULL,
    //	`email`	varchar(20)	NOT NULL,
    //	`password`	varchar(20)	NOT NULL,
    //	`id`	varchar(20)	NOT NULL,
    //	`state`	varchar(20)	NOT NULL
    //);
}
