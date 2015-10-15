package com.gls.ripple.response;

import java.util.ArrayList;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class BalanceResponse {
    long ledger;
    boolean validated;
    ArrayList<Balance> balances = new ArrayList<>();
    boolean success;

    public long getLedger() {
        return ledger;
    }

    public void setLedger(long ledger) {
        this.ledger = ledger;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public ArrayList<Balance> getBalances() {
        return balances;
    }

    public void setBalances(ArrayList<Balance> balances) {
        this.balances = balances;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
