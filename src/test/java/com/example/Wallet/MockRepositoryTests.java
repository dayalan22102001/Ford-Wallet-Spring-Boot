package com.example.Wallet;

import com.example.Wallet.WalletService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
public class MockRepositoryTests {

    @Autowired
    private WalletService walletService;

    @MockBean
    private WalletRepository walletRepository;

    @Test
    public void testServiceWithOutActualRepository() throws WalletException{
        given(this.walletRepository.getWalletById(100))
                .willReturn(new WalletDto(100,"Ford", 2500.0));
        assertEquals("Ford",walletService.getWalletByID(100).getName());
    }
    @Test
    public void testGetWalletThrowsExceptionTest() throws WalletException{

        given(this.walletRepository.getWalletById(50)).willReturn(null);
        assertThrows(WalletException.class,()->walletService.getWalletByID(50));
    }

}
