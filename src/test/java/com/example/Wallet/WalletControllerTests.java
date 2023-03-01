package com.example.Wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import javax.validation.Valid;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WalletControllerTests {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void init(){
        this.restTemplate.postForObject("http://localhost:" + port + "/v1/wallet",new WalletDto(1,"Kumar",25000.0),WalletController.class);
    }

    @Test
    public void getWalletByIdTest() throws Exception{
        WalletDto foundWallet = this.restTemplate.getForObject("http://localhost:" + port + "/v1/wallet/1",
                WalletDto.class);
        assertEquals("Kumar", foundWallet.getName());

    }

    @Test
    public void getWalletByIdExceptionTest() throws Exception {
        String WalletExceptionMessage =this.restTemplate.getForObject("http://localhost:" + port + "/v1/wallet/2",
                String.class);
        assertEquals("Id does not exist ! ",WalletExceptionMessage);
    }




}
