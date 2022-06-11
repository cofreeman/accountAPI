package com.nhnacademy.accountApi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;


    @DisplayName("createAccountTest")
    @Test
    void createAccount() throws Exception {
        Account account = Account.builder().id("123").email("jwoo1016@naver.com").password("123").build();
        given(accountService.createAccount(any())).willReturn(account);
        String s = new ObjectMapper().writeValueAsString(account);

        this.mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email",equalTo("2323")));
    }

    @Test
    void getAccount() throws Exception {
        Account account = Account.builder().id("123").email("jwoo1016@naver.com").password("123").build();
        given(accountService.findAccount(any())).willReturn(Optional.ofNullable(account));

        this.mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email",equalTo("2323")));
    }

    @Test
    void getAccounts() {
    }

    @Test
    void modifyAccount() {
    }

    @Test
    void deleteAccount() {
    }
}