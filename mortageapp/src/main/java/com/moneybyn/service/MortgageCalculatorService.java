package com.moneybyn.service;

import com.moneybyn.model.Prospect;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MortgageCalculatorService {
    private final List<Prospect> prospects = new ArrayList<>();

    public void calculateMonthlyPayments(List<Prospect> prospects) {
        for (Prospect prospect : prospects) {
            double monthlyPayment = calculateMonthlyPaymentBasic(prospect);
            prospect.setMonthlyPayment(monthlyPayment);

            // Print the result for each prospect
            System.out.printf("Prospect: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month%n",
                    prospect.getCustomerName(), prospect.getTotalLoanAmount(), prospect.getLoanPeriod(), monthlyPayment);
        }
    }

    public List<Prospect> getProspects() {
        return new ArrayList<>(prospects);
    }

    public double calculateMonthlyPaymentBasic(Prospect prospect) {
        // Convert annual interest rate to monthly and percentage to decimal
        double monthlyInterestRate = (prospect.getYearlyInterestRate() / 100.0) / 12.0;

        // Calculate the number of monthly payments
        int numberOfPayments = prospect.getLoanPeriod() * 12;

        // Calculate the monthly payment using the formula
        double monthlyPayment = (prospect.getTotalLoanAmount() * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return monthlyPayment;
    }
}
