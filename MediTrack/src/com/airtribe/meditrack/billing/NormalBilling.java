package com.airtribe.meditrack.billing;

public class NormalBilling
        implements BillingStrategy {

    @Override
    public double calculate(double amount){

        return amount + (amount * 0.18);
    }
}