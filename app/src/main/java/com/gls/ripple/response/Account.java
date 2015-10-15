package com.gls.ripple.response;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class Account {
    String name;
    String accountID;
    public Account(String name, String accountId){
        this.name = name;
        this.accountID = accountId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
