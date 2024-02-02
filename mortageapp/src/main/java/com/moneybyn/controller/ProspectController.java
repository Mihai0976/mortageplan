package com.moneybyn.controller;

import com.moneybyn.model.Prospect;
import com.moneybyn.service.MortgageCalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProspectController {
    private final MortgageCalculatorService mortgageCalculatorService;

    public ProspectController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

    @PostMapping("/calculate")
    public String calculateMonthlyPayment(@RequestBody Prospect prospect) {
        double monthlyPayment = mortgageCalculatorService.calculateMonthlyPayment(
                prospect.getTotalLoanAmount(),
                prospect.getYearlyInterestRate(),
                prospect.getLoanPeriod()
        );
        return String.format("Prospect: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month",
                prospect.getCustomerName(), prospect.getTotalLoanAmount(), prospect.getLoanPeriod(), monthlyPayment);
    }
}
