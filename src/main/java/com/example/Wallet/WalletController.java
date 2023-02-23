package com.example.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
        WalletDto updateWallet(@RequestBody WalletDto walletDto){

            return walletService.updateWallet(walletDto);
        }

        @DeleteMapping("/{id}")
        WalletDto deleteWallet(@PathVariable Integer id) throws WalletException{

            return walletService.deleteWalletById(id);

        }


        @PostMapping("/addFund/{id}")
        @ResponseStatus(value = HttpStatus.ACCEPTED)
        Double addFunds( @PathVariable Integer id, @RequestParam Double balance) throws WalletException{

            return walletService.addFunds(id,balance);
        }
        @PostMapping("/withdrawFund/{id}")
        @ResponseStatus(value = HttpStatus.ACCEPTED)
        Double withdrawFunds(@PathVariable Integer id, @RequestParam Double balance ) throws WalletException{

            return walletService.withdrawFunds(id,balance);
        }


        WalletDto fundTranfer(Integer fromId, Integer toId, Double amount){

            return null;
        }

        public List<WalletDto> getAllWallets() {

            return null;
        }

}
