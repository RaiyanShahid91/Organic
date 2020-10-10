package com.application.organic;

public class Model_Genealogy
{
    private String firsttxt,secondtxt,thirdtxt,fourthtxt,fifthtxt,sixthtxt;

    public Model_Genealogy( String firsttxt, String secondtxt, String thirdtxt,String fourthtxt,String fifthtxt) {

        this.firsttxt = firsttxt;
        this.secondtxt = secondtxt;
        this.thirdtxt = thirdtxt;
        this.fourthtxt = fourthtxt;
        this.fifthtxt=fifthtxt;

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
    public String getFourthtxt() {
        return fourthtxt;
    }
    public String getFifthtxt() {
        return fifthtxt;
    }

}
