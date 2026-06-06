package com.airtribe.meditrack.billing;

public class InsuranceBilling
        implements BillingStrategy {

    @Override
    public double calculate(double amount){

        double discounted = amount * 0.7;

        return discounted + (discounted * 0.18);
    }
}