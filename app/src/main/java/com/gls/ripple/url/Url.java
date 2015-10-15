package com.gls.ripple.url;

import android.content.Context;

import com.gls.ripple.Finals;
import com.gls.ripple.User.UserDetails;
import com.gls.ripple.response.Account;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class Url {
    Context context;
    public Url(Context context){
        this.context = context;
    }
    String baseUrl = "https://api.ripple.com/v1";
    public String getSettingUrl(){
        String url = "";
        url = baseUrl + "/accounts/"+ UserDetails.getID(context)+"/settings";
        return url;
    }

    public String getNewWalletUrl(){
        String url = "";
       url = baseUrl + "/wallet/new";
        return url;
    }

    public String getBalancesUrl(){
        String url = "";
        url = baseUrl + "/accounts/"+ UserDetails.getID(context)+"/balances";
        return url;
    }

    public String getUuidUrl(){
        String url = "";
        url = baseUrl + "/uuid";
        return url;
    }

    public String getPrepatePaymentUrl(Account account, String amount, String currency){
        //https://api.ripple.com/v1/accounts/rKQmq9RpJtrFR7cx5HbxxSYijjTcHcu7PE/payments/paths/rUoLM8DSDozPmRwXzbYpusf2xLcNtFnjeN/50+USD
        String url = "";
        url = baseUrl + "/accounts/"+
                UserDetails.getID(context)+"/payments/paths/"+
                account.getAccountID()+"/"+amount+"+"+currency;
        return url;
    }

    public String getSubnitPaymentUrl(){
        //https://api.ripple.com/v1/accounts/rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn/payments?validated=true

        String url = "";
        url = baseUrl + "/accounts/"+
                UserDetails.getID(context)+"/payments?validated=true";
        return url;
    }
    public String getConfirmPaymentUrl(String hash){
        //https://api.ripple.com/v1/accounts/rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn/payments/9D591B18EDDD34F0B6CF4223A2940AEA2C3CC778925BABF289E0011CD8FA056E
        String url = "";
        url = baseUrl + "/accounts/"+
                UserDetails.getID(context)+"/payments/"+hash;
        return url;
    }

    public String getHistoryUrl(){
        //https://api.ripple.com/v1/accounts/rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn/payments?direction=incoming&exclude_failed=true

        String url = "";
        url = baseUrl + "/accounts/"+
                UserDetails.getID(context)+"/payments?exclude_failed=true";
        return url;
    }
}
