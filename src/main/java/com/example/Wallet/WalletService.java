package com.example.Wallet;

public interface WalletService {

    WalletDto createWallet(WalletDto walletDto);

    WalletDto getWalletByID(Integer id) throws WalletException ;

    WalletDto updateWallet(WalletDto walletDto);

    WalletDto deleteWalletById(Integer id) throws WalletException;

    WalletDto getBalance(Integer id) throws WalletException;

    Double addFunds(Integer id, Double amount) throws WalletException;

    Double withdrawFunds(Integer id, Double amount) throws WalletException;

    WalletDto tranfersFunds(Integer fromId, Integer toId, Double amount) throws WalletException;

}
