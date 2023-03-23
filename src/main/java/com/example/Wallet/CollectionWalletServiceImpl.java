package com.example.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

//@Service
public class CollectionWalletServiceImpl implements WalletService{

//    @Autowired
    private CollectionWalletRepository walletRepository;

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
    public String tranfersFunds(Integer fromId, Integer toId, Double amount) {
        WalletDto fromWallet = walletRepository.getWalletById(fromId);
        WalletDto toWallet = walletRepository.getWalletById(toId);
        Double fromWalletBalance = fromWallet.getBalance() -amount;
        fromWallet.setBalance(fromWalletBalance);
        Double toWalletBalnce = toWallet.getBalance() + amount;
        toWallet.setBalance(toWalletBalnce);
        return "balance of " + fromWallet.getId() + ": " + fromWalletBalance + "\n balance of " + toWallet.getId() + ": " + toWalletBalnce;
    }

    public Collection<WalletDto> getAllWallets() {
        return this.walletRepository.getAllWallets();

    }








    }
