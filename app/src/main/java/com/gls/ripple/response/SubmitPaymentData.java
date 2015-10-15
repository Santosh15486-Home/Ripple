package com.gls.ripple.response;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class SubmitPaymentData {
    String secret;
    String client_resource_id;
    Payment payment;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getClient_resource_id() {
        return client_resource_id;
    }

    public void setClient_resource_id(String client_resource_id) {
        this.client_resource_id = client_resource_id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
