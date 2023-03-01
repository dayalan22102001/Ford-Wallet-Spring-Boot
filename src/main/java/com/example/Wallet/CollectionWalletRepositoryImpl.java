package com.example.Wallet;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CollectionWalletRepositoryImpl implements CollectionWalletRepository {

    Map<Integer, WalletDto> walletDtoMap = new HashMap<>();

    public WalletDto createWallet(WalletDto walletDto) {
        walletDtoMap.put(walletDto.getId(), walletDto);
        return walletDto;
    }

    public WalletDto getWalletById(Integer id) {

        return walletDtoMap.get(id);
    }

    public WalletDto updateWallet(WalletDto walletDto) {
        walletDtoMap.replace(walletDto.getId(), walletDto);
        return walletDto;
    }

    public WalletDto deleteWalletById(Integer id) {

        walletDtoMap.remove(id);
        return walletDtoMap.get(id);
    }

    public Collection<WalletDto> getAllWallets() {

        return  this.walletDtoMap.values();
    }

}



