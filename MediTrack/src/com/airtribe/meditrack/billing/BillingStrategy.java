package com.airtribe.meditrack.billing;

public interface BillingStrategy {

    double calculate(double amount);
}