package com.airtribe.meditrack.entity;

public final class BillSummary {

    private final int billId;
    private final double total;

    public BillSummary(int billId,double total){

        this.billId=billId;
        this.total=total;
    }

    public int getBillId(){
        return billId;
    }

    public double getTotal(){
        return total;
    }
}