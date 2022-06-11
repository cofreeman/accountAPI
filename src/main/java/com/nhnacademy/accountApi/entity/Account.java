package com.nhnacademy.accountApi.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long accountId;
    private String id;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private AccountState state;

    @Builder
    public Account(String id,String password,String email) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.state = AccountState.JOIN;
    }


    //TODO:VALIDATION
    //CREATE TABLE `users` (
    //	`user_id`	bigint	NOT NULL,
    //	`email`	varchar(20)	NOT NULL,
    //	`password`	varchar(20)	NOT NULL,
    //	`id`	varchar(20)	NOT NULL,
    //	`state`	varchar(20)	NOT NULL
    //);

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
