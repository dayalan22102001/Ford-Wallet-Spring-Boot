package com.example.Wallet;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

    Map<Integer,WalletDto> walletDtoMap = new HashMap<>();

    public WalletDto createWallet(WalletDto walletDto){
        walletDtoMap.put(walletDto.getId(), walletDto);
        return walletDto;
    }

    public WalletDto getWalletById(Integer id){

        return walletDtoMap.get(id);
    }

    public WalletDto updateWallet(WalletDto walletDto){
        walletDtoMap.replace(walletDto.getId(), walletDto);
        return walletDto;
    }

    public WalletDto deleteWalletById(Integer id){

        walletDtoMap.remove(id);
        return walletDtoMap.get(id);
    }


}
