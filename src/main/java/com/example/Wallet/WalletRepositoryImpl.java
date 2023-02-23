package com.example.Wallet;

import org.springframework.stereotype.Repository;

import java.util.stream.*;
import java.util.*;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

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

    @Override
    public ArrayList<WalletDto> getAllWallets() {

        ArrayList<WalletDto> ListofValues = null;


        ListofValues = walletDtoMap.values().stream().collect(Collectors.toCollection(ArrayList::new));

        return ListofValues;

    }

}



