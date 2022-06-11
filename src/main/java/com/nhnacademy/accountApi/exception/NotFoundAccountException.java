package com.nhnacademy.accountApi.exception;

public class NotFoundAccountException extends IllegalArgumentException{

    public NotFoundAccountException() {
        super("해당 아이디를 찾을 수 없습니다.");
    }
}
