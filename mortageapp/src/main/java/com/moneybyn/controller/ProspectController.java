package com.moneybyn.controller;

import com.moneybyn.model.Prospect;
import com.moneybyn.service.MortgageCalculatorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ProspectController {
    private final MortgageCalculatorService mortgageCalculatorService;


    public ProspectController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

    @GetMapping("/view")
    public String viewProspects(Model model) {
        List<Prospect> prospects = mortgageCalculatorService.getProspects();
        model.addAttribute("prospects", prospects);
        model.addAttribute("newProspect", new Prospect());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateMonthlyPayment(@ModelAttribute("newProspect") Prospect newProspect) {
        mortgageCalculatorService.calculateMonthlyPaymentBasic(newProspect);
        return "redirect:/web/view";
    }
}

