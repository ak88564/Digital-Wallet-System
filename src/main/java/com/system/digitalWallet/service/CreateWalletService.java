package com.system.digitalWallet.service;

import com.system.digitalWallet.entity.Wallet;

import java.util.List;

public interface CreateWalletService {
    Wallet saveWallet(Wallet wallet);

    void transferAmount(Long accountNum1, Long accountNum2, Long amount);

    List<Wallet> taskList();
}
