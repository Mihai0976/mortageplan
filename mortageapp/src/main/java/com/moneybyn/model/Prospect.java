package com.moneybyn.model;

public class Prospect {
    private String customerName;
    private double totalLoanAmount;
    private double yearlyInterestRate;
    private int loanPeriod;
    private double monthlyPayment;

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
}
