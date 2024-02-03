package com.moneybyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model) {
        // You can add model attributes if needed
        model.addAttribute("message", "Welcome to MoneyBin Web Interface!");
        return "index";
    }
}



