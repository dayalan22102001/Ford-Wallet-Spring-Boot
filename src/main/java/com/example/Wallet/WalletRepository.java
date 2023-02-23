package com.example.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface WalletRepository {

    WalletDto createWallet (WalletDto walletDto);
    WalletDto getWalletById( Integer id) ;
    WalletDto updateWallet(WalletDto walletDto);
    WalletDto deleteWalletById(Integer id) ;
    public ArrayList<WalletDto> getAllWallets();

}
