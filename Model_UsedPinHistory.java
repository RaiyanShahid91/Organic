package com.application.organic;

public class Model_UsedPinHistory {

    private String epin;
    private String membercode;
    private String purchasedate;
    private String pinvalue;
    private String activatedmember;
    private String activatedmembername;
    private String status;

    public Model_UsedPinHistory(String epin, String membercode, String purchasedate, String pinvalue, String activatedmember, String activatedmembername, String status) {
        this.epin = epin;
        this.membercode = membercode;
        this.purchasedate = purchasedate;
        this.pinvalue = pinvalue;
        this.activatedmember = activatedmember;
        this.activatedmembername = activatedmembername;
        this.status = status;
    }

    public String getEpin() {
        return epin;
    }

    public String getMembercode() {
        return membercode;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public String getPinvalue() {
        return pinvalue;
    }

    public String getActivatedmember() {
        return activatedmember;
    }

    public String getActivatedmembername() {
        return activatedmembername;
    }

    public String getStatus() {
        return status;
    }
}