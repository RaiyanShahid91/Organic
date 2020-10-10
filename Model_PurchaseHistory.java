package com.application.organic;

public class Model_PurchaseHistory
{
    String membercode,nofofpin,purchasedate,pinvalue,purchasevalue,status;

    public Model_PurchaseHistory(String membercode, String nofofpin, String purchasedate, String pinvalue, String purchasevalue, String status) {
        this.membercode = membercode;
        this.nofofpin = nofofpin;
        this.purchasedate = purchasedate;
        this.pinvalue = pinvalue;
        this.purchasevalue = purchasevalue;
        this.status = status;
    }

    public String getMembercode() {
        return membercode;
    }

    public String getNofofpin() {
        return nofofpin;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public String getPinvalue() {
        return pinvalue;
    }

    public String getPurchasevalue() {
        return purchasevalue;
    }

    public String getStatus() {
        return status;
    }
}
