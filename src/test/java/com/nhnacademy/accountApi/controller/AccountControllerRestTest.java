package com.nhnacademy.accountApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.accountApi.entity.Account;
import com.nhnacademy.accountApi.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;

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
class AccountControllerRestTest {


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
        Account account = Account.builder().id("123").email("jwoo1016@naver.com").password("123").build();
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