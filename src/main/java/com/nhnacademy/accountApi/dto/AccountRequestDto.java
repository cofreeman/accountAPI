package com.nhnacademy.accountApi.dto;

import com.nhnacademy.accountApi.entity.AccountState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AccountRequestDto {
    //todo:

    private String id;
    private String password;
    private String email;
    private AccountState state;

}
