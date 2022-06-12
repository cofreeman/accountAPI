package com.nhnacademy.accountApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AccountRequestDto {

    private String id;
    private String password;
    private String email;

}
