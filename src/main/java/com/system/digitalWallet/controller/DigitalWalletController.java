package com.system.digitalWallet.controller;

import com.system.digitalWallet.entity.Wallet;
import com.system.digitalWallet.service.CreateWalletService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    // When the user clicks on transferAmount button then this method is executed
    @GetMapping("/homePage/transfer")
    public String openTransferAmountForm(Model model) {
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();
        model.addAttribute("wallet", wallet1);
        model.addAttribute("wallet", wallet2);
        return "transfer_amount"; // opens transfer_amount.html

    }

    // When the user submits the transfer money form, this method is executed
    @PostMapping("/homePage/transfer")
    public String transferAmount(@RequestParam("acc_num1") Long acc_num1, @RequestParam("acc_num2") Long acc_num2,
                                 @RequestParam("amt") Long amt, Model model) {
        createWalletService.transferAmount(acc_num1, acc_num2, amt);

        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "redirect:/homePage"; // opens digital_wallet.html
    }

    @GetMapping("/homePage/overview")
    public String openOverview(Model model) {
        List<Wallet> datas = createWalletService.taskList();
        model.addAttribute("datas", datas);
        return "overview";

    }
}
