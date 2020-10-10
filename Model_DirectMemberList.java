package com.application.organic;

public class Model_DirectMemberList
{
    String Mmebercode,memebername,joiningdate,activationdate,currentself,accumulatedself,accumulategroup,currentgroup;

    public Model_DirectMemberList(String mmebercode, String memebername, String joiningdate, String activationdate, String currentself, String accumulatedself, String accumulategroup, String currentgroup) {
        Mmebercode = mmebercode;
        this.memebername = memebername;
        this.joiningdate = joiningdate;
        this.activationdate = activationdate;
        this.currentself = currentself;
        this.accumulatedself = accumulatedself;
        this.accumulategroup = accumulategroup;
        this.currentgroup = currentgroup;
    }

    public String getMmebercode() {
        return Mmebercode;
    }

    public String getMemebername() {
        return memebername;
    }

    public String getJoiningdate() {
        return joiningdate;
    }

    public String getActivationdate() {
        return activationdate;
    }

    public String getCurrentself() {
        return currentself;
    }

    public String getAccumulatedself() {
        return accumulatedself;
    }

    public String getAccumulategroup() {
        return accumulategroup;
    }

    public String getCurrentgroup() {
        return currentgroup;
    }
}
