package com.system.digitalWallet.controller;

import com.system.digitalWallet.entity.Wallet;
import com.system.digitalWallet.service.CreateWalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DigitalWalletController {

    private CreateWalletService createWalletService;

    public DigitalWalletController(CreateWalletService createWalletService) {
        this.createWalletService = createWalletService;
    }

    @GetMapping("/homePage")
    public String listStudents(){
//        model.addAttribute("students", studentService.getAllStudents());
        return "digital_wallet"; // opens digital_wallet.html
    }

    // When the user clicks on createWallet button then this method is executed
    @GetMapping("/homePage/create")
    public String createWalletForm(Model model) {

        // create wallet object to hold wallet form data
        Wallet wallet = new Wallet();
        model.addAttribute("wallet", wallet);
        return "create_wallet"; // return/open create_wallet.html
    }

    // When the user submits the form, this method is executed
    @PostMapping("/homePage")
    public String createWallet(Wallet wallet) {
        createWalletService.saveWallet(wallet);
        return "redirect:/homePage"; // opens digital_wallet.html
    }
}
