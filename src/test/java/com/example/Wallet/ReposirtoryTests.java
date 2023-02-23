package com.example.Wallet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReposirtoryTests {
    @Autowired
    private WalletRepository walletRepository;

    @BeforeEach
    public void init(){
        walletRepository.createWallet(new WalletDto(11, "Kumar", 9090.0));

    }

    @Test
    public void deleteWalletTest(){
        WalletDto deletedWallet = walletRepository.deleteWalletById(11);
        assertEquals("Kumar", deletedWallet.getName());
    }

}
