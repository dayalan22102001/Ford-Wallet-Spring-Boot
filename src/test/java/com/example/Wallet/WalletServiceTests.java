package com.example.Wallet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WalletServiceTests {

    @Autowired
    private WalletService walletService;

    @Test
    void createWalletTest(){
        WalletDto newWallet = new WalletDto(1,"Dayalan",2345.0);
        assertEquals("Dayalan", this.walletService.createWallet(newWallet).getName());
    }
}
