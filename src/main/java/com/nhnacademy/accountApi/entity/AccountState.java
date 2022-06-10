package com.nhnacademy.accountApi.entity;

import lombok.Getter;

public enum AccountState {
    JOIN("가입"),
    DELETED("탈퇴"),
    RESTING("휴면");

    @Getter
    private final String state;

    AccountState(String state) {
        this.state = state;
    }
}

