package com.gls.ripple.response;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class Balance {
    String value;
    String currency;
    String counterparty;
    String issuer;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    @Override
    public String toString() {
        return getCurrency();
    }
}
