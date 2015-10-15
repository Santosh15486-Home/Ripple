package com.gls.ripple.response;

import java.util.ArrayList;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class PreparePaymentResponse {
    ArrayList<Payment> payments = new ArrayList<>();
    boolean success;

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
