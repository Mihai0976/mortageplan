package com.moneybyn.service;

import com.moneybyn.model.Prospect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
MortgageCalculatorService {
    public void calculateMonthlyPayments(List<Prospect> prospects) {
        for (Prospect prospect : prospects) {
            double monthlyPayment = calculateMonthlyPayment(
                    prospect.getTotalLoanAmount(),
                    prospect.getYearlyInterestRate(),
                    prospect.getLoanPeriod()
            );

            // Print the result for each prospect
            System.out.printf("Prospect: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month%n",
                    prospect.getCustomerName(), prospect.getTotalLoanAmount(), prospect.getLoanPeriod(), monthlyPayment);
        }
    }
    public double calculateMonthlyPayment(double principal, double annualInterestRate, int loanPeriod) {
        // Convert annual interest rate to monthly and percentage to decimal
        double monthlyInterestRate = (annualInterestRate / 100.0) / 12.0;

        // Calculate the number of monthly payments
        int numberOfPayments = loanPeriod * 12;

        // Calculate the monthly payment using the formula
        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return monthlyPayment;
    }
}
