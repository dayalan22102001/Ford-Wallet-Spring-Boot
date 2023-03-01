package com.example.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletJpaRepository walletJpaRepository;
    @Override
    public WalletDto createWallet(WalletDto walletDto) {
        return this.walletJpaRepository.save(walletDto);
    }

    @Override
    public WalletDto getWalletByID(Integer id) throws WalletException {
        Optional<WalletDto> walletDtoOptional = this.walletJpaRepository.findById(id);
        if ( walletDtoOptional.isEmpty()){
            throw new WalletException("Wallet of id " + id + " could not be found !");

        }
        return walletDtoOptional.get();
    }

    @Override
    public WalletDto updateWallet(WalletDto walletDto) throws WalletException {

        Optional<WalletDto> walletDtoOptional = this.walletJpaRepository.findById(walletDto.getId());
        if ( walletDtoOptional.isEmpty()){
            throw new WalletException("Wallet could not be found !");

        }
        return this.walletJpaRepository.save(walletDto);
    }

    @Override
    public WalletDto deleteWalletById(Integer id) throws WalletException {
        Optional<WalletDto> walletDtoOptional = this.walletJpaRepository.findById(id);
        if ( walletDtoOptional.isEmpty()){
            throw new WalletException("Wallet of id " + id + " could not be found !");

        }

        WalletDto foundWallet = walletDtoOptional.get();
        this.walletJpaRepository.delete(foundWallet);
        return foundWallet;

    }

    @Override
    public Double addFunds(Integer id, Double amount) throws WalletException {
        Optional<WalletDto> walletDtoOptional = this.walletJpaRepository.findById(id);
        if ( walletDtoOptional.isEmpty()){
            throw new WalletException("Wallet of id " + id + " could not be found !");

        }
        WalletDto foundWallet = walletDtoOptional.get();
        Double newBalance = foundWallet.getBalance() + amount;
        foundWallet.setBalance(newBalance);
        this.walletJpaRepository.save(foundWallet);
        return newBalance;
    }

    @Override
    public Double withdrawFunds(Integer id, Double amount) throws WalletException {
        Optional<WalletDto> walletDtoOptional = this.walletJpaRepository.findById(id);
        if ( walletDtoOptional.isEmpty()){
            throw new WalletException("Wallet of id " + id + " could not be found !");

        }
        WalletDto foundWallet = walletDtoOptional.get();
        Double newBalance = foundWallet.getBalance() - amount;
        foundWallet.setBalance(newBalance);
        this.walletJpaRepository.save(foundWallet);
        return newBalance;
    }

    @Override
    public String tranfersFunds(Integer fromId, Integer toId, Double amount) throws WalletException {
        Optional<WalletDto> fromWalletDtoOptional = this.walletJpaRepository.findById(fromId);
        Optional<WalletDto> toWalletDtoOptional = this.walletJpaRepository.findById(toId);
        if ( fromWalletDtoOptional.isEmpty() || toWalletDtoOptional.isEmpty()){
            throw new WalletException("Enter valid ID");

        }
        WalletDto fromWallet =fromWalletDtoOptional.get();
        WalletDto toWallet = toWalletDtoOptional.get();

        Double fromWalletBalance = fromWallet.getBalance() - amount ;
        Double toWalletBalance = toWallet.getBalance() + amount;

        fromWallet.setBalance(fromWalletBalance);
        toWallet.setBalance(toWalletBalance);

        this.walletJpaRepository.save(fromWallet);
        this.walletJpaRepository.save(toWallet);
        return "Tranfer Complete" + "\n Balance of : \n "+fromId + " : "+fromWalletBalance
                +" \n " + toId + " : " + toWalletBalance;
    }

    @Override
    public Collection<WalletDto> getAllWallets() {
        return this.walletJpaRepository.findAll();
    }
}
