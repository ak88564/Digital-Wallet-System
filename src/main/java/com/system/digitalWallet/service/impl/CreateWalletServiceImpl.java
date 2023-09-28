package com.system.digitalWallet.service.impl;

import com.system.digitalWallet.entity.Wallet;
import com.system.digitalWallet.repository.WalletRepository;
import com.system.digitalWallet.service.CreateWalletService;
import org.springframework.stereotype.Service;

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

}
