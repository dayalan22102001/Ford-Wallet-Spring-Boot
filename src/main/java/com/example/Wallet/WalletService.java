package com.example.Wallet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface WalletService {

    WalletDto createWallet(WalletDto walletDto);

    WalletDto getWalletByID(Integer id) throws WalletException ;

    WalletDto updateWallet(WalletDto walletDto) throws WalletException;

    WalletDto deleteWalletById(Integer id) throws WalletException;

    Double addFunds(Integer id, Double amount) throws WalletException;

    Double withdrawFunds(Integer id, Double amount) throws WalletException;

    String tranfersFunds(Integer fromId, Integer toId, Double amount) throws WalletException;

    public Collection<WalletDto> getAllWallets();

}
