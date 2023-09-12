package com.system.digitalWallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DigitalWalletController {

    @GetMapping("/students")
    public String listStudents(){
//        model.addAttribute("students", studentService.getAllStudents());
        return "digital_wallet";
    }
}
