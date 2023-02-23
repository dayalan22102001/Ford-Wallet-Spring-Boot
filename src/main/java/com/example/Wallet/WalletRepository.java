package com.example.Wallet;

public interface WalletRepository {

    WalletDto createWallet (WalletDto walletDto);
    WalletDto getWalletById( Integer id) ;
    WalletDto updateWallet(WalletDto walletDto);
    WalletDto deleteWalletById(Integer id) ;

}
