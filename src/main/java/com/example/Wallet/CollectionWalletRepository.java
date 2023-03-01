package com.example.Wallet;

import java.util.Collection;

public interface CollectionWalletRepository {

    WalletDto createWallet (WalletDto walletDto);
    WalletDto getWalletById( Integer id) ;
    WalletDto updateWallet(WalletDto walletDto);
    WalletDto deleteWalletById(Integer id) ;
    public Collection<WalletDto> getAllWallets();
}
