package com.system.digitalWallet.service.impl;

import com.system.digitalWallet.entity.Wallet;
import com.system.digitalWallet.repository.WalletRepository;
import com.system.digitalWallet.service.CreateWalletService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreateWalletServiceImpl implements CreateWalletService {

    private WalletRepository walletRepository;

    public CreateWalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void transferAmount(Long accountNum1, Long accountNum2, Long amount) {
//        Long accoun1 = (Long)accountNum1;
        Wallet updateWallet1 = walletRepository.findById(accountNum1).orElse(null);
        Wallet updateWallet2 = walletRepository.findById(accountNum2).orElse(null);
//        int temp = walletRepository.findById(wallet.getId()).getAmount();
        if (updateWallet1 != null && updateWallet2 !=null){
            updateWallet1.setAmount(updateWallet1.getAmount() - amount);
            walletRepository.save(updateWallet1);

            updateWallet2.setAmount(updateWallet2.getAmount() + amount);
            walletRepository.save(updateWallet2);
        }
        System.out.println("Transfer successful");

    }

    @Override
    public List<Wallet> taskList() {
        return (walletRepository.findAll());
    }


}
