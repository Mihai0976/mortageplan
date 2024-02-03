package com.moneybyn.controller;

import com.moneybyn.model.Prospect;
import com.moneybyn.service.MortgageCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProspectController {
    private final MortgageCalculatorService mortgageCalculatorService;


    public ProspectController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }


    @GetMapping("/web/view")
    public String viewProspects(Model model) {
        // This ensures that a newProspect object is always available to the form,
        // even after redirecting back from the calculate endpoint.
        if (!model.containsAttribute("newProspect")) {
            model.addAttribute("newProspect", new Prospect());
        }
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateMonthlyPayment(@ModelAttribute("newProspect") Prospect newProspect, RedirectAttributes redirectAttributes) {
        // Calculate the monthly payment
        double monthlyPayment = mortgageCalculatorService.calculateMonthlyPaymentBasic(newProspect);

        // Set the calculated monthly payment on the prospect
        newProspect.setMonthlyPayment(monthlyPayment);

        // Use flash attributes to pass the updated prospect through the redirect
        redirectAttributes.addFlashAttribute("newProspect", newProspect);

        // Redirect back to the form page
        return "redirect:/web/view";
    }

}

