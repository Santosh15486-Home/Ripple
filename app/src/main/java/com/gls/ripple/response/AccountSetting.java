package com.gls.ripple.response;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class AccountSetting {
    String account;//rKQmq9RpJtrFR7cx5HbxxSYijjTcHcu7PE",
    String transfer_rate;
    boolean password_spent;
    boolean require_destination_tag;
    boolean require_authorization;
    boolean disallow_xrp;
    boolean disable_master;
    boolean no_freeze;
    boolean global_freeze;
    boolean default_ripple;
    String transaction_sequence;
    String email_hash;
    String wallet_locator;
    String wallet_size;
    String message_key;
    String domain;
    String signers;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTransfer_rate() {
        return transfer_rate;
    }

    public void setTransfer_rate(String transfer_rate) {
        this.transfer_rate = transfer_rate;
    }

    public boolean isPassword_spent() {
        return password_spent;
    }

    public void setPassword_spent(boolean password_spent) {
        this.password_spent = password_spent;
    }

    public boolean isRequire_destination_tag() {
        return require_destination_tag;
    }

    public void setRequire_destination_tag(boolean require_destination_tag) {
        this.require_destination_tag = require_destination_tag;
    }

    public boolean isRequire_authorization() {
        return require_authorization;
    }

    public void setRequire_authorization(boolean require_authorization) {
        this.require_authorization = require_authorization;
    }

    public boolean isDisallow_xrp() {
        return disallow_xrp;
    }

    public void setDisallow_xrp(boolean disallow_xrp) {
        this.disallow_xrp = disallow_xrp;
    }

    public boolean isDisable_master() {
        return disable_master;
    }

    public void setDisable_master(boolean disable_master) {
        this.disable_master = disable_master;
    }

    public boolean isNo_freeze() {
        return no_freeze;
    }

    public void setNo_freeze(boolean no_freeze) {
        this.no_freeze = no_freeze;
    }

    public boolean isGlobal_freeze() {
        return global_freeze;
    }

    public void setGlobal_freeze(boolean global_freeze) {
        this.global_freeze = global_freeze;
    }

    public boolean isDefault_ripple() {
        return default_ripple;
    }

    public void setDefault_ripple(boolean default_ripple) {
        this.default_ripple = default_ripple;
    }

    public String getTransaction_sequence() {
        return transaction_sequence;
    }

    public void setTransaction_sequence(String transaction_sequence) {
        this.transaction_sequence = transaction_sequence;
    }

    public String getEmail_hash() {
        return email_hash;
    }

    public void setEmail_hash(String email_hash) {
        this.email_hash = email_hash;
    }

    public String getWallet_locator() {
        return wallet_locator;
    }

    public void setWallet_locator(String wallet_locator) {
        this.wallet_locator = wallet_locator;
    }

    public String getWallet_size() {
        return wallet_size;
    }

    public void setWallet_size(String wallet_size) {
        this.wallet_size = wallet_size;
    }

    public String getMessage_key() {
        return message_key;
    }

    public void setMessage_key(String message_key) {
        this.message_key = message_key;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSigners() {
        return signers;
    }

    public void setSigners(String signers) {
        this.signers = signers;
    }
}
