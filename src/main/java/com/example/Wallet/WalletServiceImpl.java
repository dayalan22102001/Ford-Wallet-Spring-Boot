package com.example.Wallet;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    public WalletDto createWallet(WalletDto walletDto){

        return walletRepository.createWallet(walletDto);
    }

    @Override
    public WalletDto getWalletByID(Integer id) throws WalletException{
        WalletDto temp =walletRepository.getWalletById(id);
        if(temp == null){
            throw new WalletException("Id does not exist ! ");
        }
        return temp;
    }

    WalletDto getWalletById(Integer id){

        return walletRepository.getWalletById(id);
    }
    public WalletDto updateWallet(WalletDto walletDto){

        return walletRepository.updateWallet(walletDto);
    }

    @Override
    public WalletDto deleteWalletById(Integer id) throws WalletException {

        WalletDto temp = walletRepository.getWalletById(id);
        if(temp == null){
            throw new WalletException("Id does not exist ! ");
        }
        this.walletRepository.deleteWalletById(id);
        return temp;
    }

    @Override
    public WalletDto getBalance(Integer id) throws WalletException {
        return null;
    }

    public Double addFunds(Integer id, Double amount){

        WalletDto foundWallet = walletRepository.getWalletById(id);
        Double newBalance= foundWallet.getBalance()+ amount;
        foundWallet.setBalance(newBalance);
        walletRepository.updateWallet(foundWallet);
        return newBalance;

    }

    public Double withdrawFunds(Integer id, Double amount){
        WalletDto foundWallet = walletRepository.getWalletById(id);
        Double newBalance= foundWallet.getBalance()- amount;
        foundWallet.setBalance(newBalance);
        walletRepository.updateWallet(foundWallet);
        return newBalance;
    }

    @Override
    public WalletDto tranfersFunds(Integer fromId, Integer toId, Double amount) {
        return null;
    }




}
