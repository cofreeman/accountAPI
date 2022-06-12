package com.nhnacademy.accountApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.accountApi.dto.AccountRequestDto;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {


    private final String id = "id";
    private final String password = "password";
    private final String email = "email";
    private final String id2 = "id2";
    private final String password2 = "password2";
    private final String email2 = "email2";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountService accountService;

    @DisplayName("회원 가입")
    @Test
    void createAccount() throws Exception {
        Account account = Account.builder().id(id).password(password).email(email).build();
        given(accountService.createAccount(any())).willReturn(account);
        String s = new ObjectMapper().writeValueAsString(account);

        this.mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(id)));
    }

    @DisplayName("회원 단건 조회")
    @Test
    void getAccount() throws Exception {
        Account account = Account.builder().id(id).password(password).email(email).build();
        given(accountService.findAccount(any())).willReturn(account);

        this.mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(id)));
    }

    @DisplayName("전체 회원 조회")
    @Test
    void getAccounts() throws Exception {
        Account account1 = Account.builder().id(id).password(password).email(email).build();
        Account account2 = Account.builder().id(id2).password(password2).email(email2).build();
        given(accountService.findAccounts()).willReturn(List.of(account1, account2));

        this.mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo(id)))
                .andExpect(jsonPath("$[1].id", equalTo(id2)));
    }

    //todo: 통과 안됨
    @DisplayName("회원 정보 변경")
    @Test
    void modifyAccount() throws Exception {
        AccountRequestDto accountRequestDto = new AccountRequestDto(id2, password2, email2);
        Account account = Account.builder().id(id2).password(password2).email(email2).build();

        given(accountService.modifyAccount(any(), any())).willReturn(account);

        this.mockMvc.perform(post("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(id2)));
    }

}