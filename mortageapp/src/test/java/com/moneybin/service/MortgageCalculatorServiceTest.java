package com.moneybin.service;

import com.moneybyn.model.Prospect;
import com.moneybyn.service.MortgageCalculatorService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgageCalculatorServiceTest {

    @Test
    public void testCalculateMonthlyPayments() {
        MortgageCalculatorService mortgageCalculatorService = new MortgageCalculatorService();

        // Create a list of prospects for testing
        List<Prospect> prospects = new ArrayList<>();
        prospects.add(createProspect("John Doe", 1000.0, 5.0, 2));
        prospects.add(createProspect("Jane Smith", 2000.0, 6.0, 4));

        // Calculate monthly payments
        mortgageCalculatorService.calculateMonthlyPayments(prospects);

        // Verify the results
        assertEquals(43.87, prospects.get(0).getMonthlyPayment(), 0.01);
        assertEquals(46.97, prospects.get(1).getMonthlyPayment(), 0.01);
    }

    @Test
    public void testCalculateMonthlyPaymentBasic() {
        MortgageCalculatorService mortgageCalculatorService = new MortgageCalculatorService();

        // Create a single prospect for testing
        Prospect prospect = createProspect("John Doe", 1000.0, 5.0, 10);

        // Calculate monthly payment for the single prospect
        double monthlyPayment = mortgageCalculatorService.calculateMonthlyPaymentBasic(prospect);

        // Verify the result
        assertEquals(10.61, monthlyPayment, 0.01); // Adjust the expected value if necessary
    }


    private Prospect createProspect(String customerName, double totalLoanAmount, double yearlyInterestRate, int loanPeriod) {
        Prospect prospect = new Prospect();
        prospect.setCustomerName(customerName);
        prospect.setTotalLoanAmount(totalLoanAmount);
        prospect.setYearlyInterestRate(yearlyInterestRate);
        prospect.setLoanPeriod(loanPeriod);
        return prospect;
    }
}
