package com.example.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/wallet/")
public class WalletController {

        @Autowired
        WalletService walletService;

        @PostMapping("/")
        @ResponseStatus(value = HttpStatus.CREATED)
        WalletDto addWallet(@Valid @RequestBody WalletDto walletDto) {

            return walletService.createWallet(walletDto);
        }

        @GetMapping("/{id}")
        WalletDto getWalletById(@PathVariable Integer id) throws WalletException{
            return walletService.getWalletByID(id);
        }

        @PutMapping("/")
        WalletDto updateWallet(@RequestBody WalletDto walletDto) throws WalletException {

            return walletService.updateWallet(walletDto);
        }

        @DeleteMapping("/{id}")
        WalletDto deleteWallet(@PathVariable Integer id) throws WalletException{

            return walletService.deleteWalletById(id);

        }


        @PatchMapping("/addFund/{id}")
        @ResponseStatus(value = HttpStatus.ACCEPTED)
        Double addFunds( @PathVariable Integer id, @RequestParam Double balance) throws WalletException{

            return walletService.addFunds(id,balance);
        }
        @PatchMapping ("/withdrawFund/{id}")
        @ResponseStatus(value = HttpStatus.ACCEPTED)
        Double withdrawFunds(@PathVariable Integer id, @RequestParam Double balance ) throws WalletException{

            return walletService.withdrawFunds(id,balance);
        }


        @PatchMapping("/tranferFunds/{fromId}/{toId}")
        @ResponseStatus(value = HttpStatus.ACCEPTED)
        String fundTranfer(Integer fromId, Integer toId, Double amount) throws WalletException{

            return walletService.tranfersFunds(fromId,toId,amount);
        }

    @GetMapping("wallets")
    public Collection<WalletDto> getAllWallets(){
        return this.walletService.getAllWallets();
    }


}
