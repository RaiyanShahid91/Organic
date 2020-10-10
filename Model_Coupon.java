package com.application.organic;

public class Model_Coupon
{
    private String firsttxt,secondtxt,thirdtxt;
    private int imagefirst;

    public Model_Coupon(String firsttxt, String secondtxt, String thirdtxt, int imagefirst) {
        this.firsttxt = firsttxt;
        this.secondtxt = secondtxt;
        this.thirdtxt = thirdtxt;
        this.imagefirst = imagefirst;
    }

    public String getFirsttxt() {
        return firsttxt;
    }

    public String getSecondtxt() {
        return secondtxt;
    }

    public String getThirdtxt() {
        return thirdtxt;
    }

    public int getImagefirst() {
        return imagefirst;
    }
}
