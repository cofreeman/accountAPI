package com.nhnacademy.accountApi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.repository.AccountRepository;
import com.nhnacademy.accountApi.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//question: 이건 뭔죠?
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@WebMvcTest(AccountController.class)
//@Transactional
class AccountControllerTest {


    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @MockBean
    private AccountService accountService;


//question: 이건 통합테스트 아닙니까 controller 자체만 테스트 해야되지 않나요?
    @DisplayName("create account test")
    @Test
    void createAccount() throws Exception {
        Account account = new Account(1L, "2323", "", "", "");
        given(accountService.createAccount(any())).willReturn(account);
        String s = new ObjectMapper().writeValueAsString(account);

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<Account> httpEntity = new HttpEntity<>(account,httpHeaders);
//        ResponseEntity<Account> exchange = testRestTemplate.exchange("/accounts", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<Account>() {
//        });

        this.mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                        .andExpect(status().isCreated())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.email",equalTo("2323")));
    }

    @DisplayName("")
    @Test
    void getAccount() {
    }

    @DisplayName("")
    @Test
    void getAccounts() {
    }

    @DisplayName("")
    @Test
    void modifyAccount() {
    }

    @DisplayName("")
    @Test
    void deleteAccount() {
    }
}