package com.gls.ripple.response;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class SubmitPaymentResponse {
    Payment payment;
    String client_resource_id;
    String hash;
    String ledger;
    String state;
    boolean success;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getClient_resource_id() {
        return client_resource_id;
    }

    public void setClient_resource_id(String client_resource_id) {
        this.client_resource_id = client_resource_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLedger() {
        return ledger;
    }

    public void setLedger(String ledger) {
        this.ledger = ledger;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
