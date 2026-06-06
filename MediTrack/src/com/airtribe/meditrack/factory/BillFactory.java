package com.airtribe.meditrack.factory;

import com.airtribe.meditrack.billing.BillingStrategy;
import com.airtribe.meditrack.billing.InsuranceBilling;
import com.airtribe.meditrack.billing.NormalBilling;

public class BillFactory {

    public static BillingStrategy getStrategy(
            int type
    ){

        if(type == 2){

            return new InsuranceBilling();
        }

        return new NormalBilling();
    }
}