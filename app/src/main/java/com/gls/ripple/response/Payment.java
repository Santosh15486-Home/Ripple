package com.gls.ripple.response;

import java.util.ArrayList;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class Payment {
    String source_account;
    String source_tag;
    Balance source_amount;
    String source_slippage;
    String destination_account;
    String destination_tag;
    Balance destination_amount;
    String invoice_id;
    String paths;
    boolean partial_payment;
    boolean no_direct_ripple;
    String currency;
    String direction;
    String timestamp;
    String fee;
    String result;
    ArrayList<Balance> balance_changes;
    ArrayList<Balance> destination_balance_changes;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Balance> getBalance_changes() {
        return balance_changes;
    }

    public void setBalance_changes(ArrayList<Balance> balance_changes) {
        this.balance_changes = balance_changes;
    }

    public ArrayList<Balance> getDestination_balance_changes() {
        return destination_balance_changes;
    }

    public void setDestination_balance_changes(ArrayList<Balance> destination_balance_changes) {
        this.destination_balance_changes = destination_balance_changes;
    }

    public String getSource_account() {
        return source_account;
    }

    public void setSource_account(String source_account) {
        this.source_account = source_account;
    }

    public String getSource_tag() {
        return source_tag;
    }

    public void setSource_tag(String source_tag) {
        this.source_tag = source_tag;
    }

    public Balance getSource_amount() {
        return source_amount;
    }

    public void setSource_amount(Balance source_amount) {
        this.source_amount = source_amount;
    }

    public String getSource_slippage() {
        return source_slippage;
    }

    public void setSource_slippage(String source_slippage) {
        this.source_slippage = source_slippage;
    }

    public String getDestination_account() {
        return destination_account;
    }

    public void setDestination_account(String destination_account) {
        this.destination_account = destination_account;
    }

    public String getDestination_tag() {
        return destination_tag;
    }

    public void setDestination_tag(String destination_tag) {
        this.destination_tag = destination_tag;
    }

    public Balance getDestination_amount() {
        return destination_amount;
    }

    public void setDestination_amount(Balance destination_amount) {
        this.destination_amount = destination_amount;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths;
    }

    public boolean isPartial_payment() {
        return partial_payment;
    }

    public void setPartial_payment(boolean partial_payment) {
        this.partial_payment = partial_payment;
    }

    public boolean isNo_direct_ripple() {
        return no_direct_ripple;
    }

    public void setNo_direct_ripple(boolean no_direct_ripple) {
        this.no_direct_ripple = no_direct_ripple;
    }


}
