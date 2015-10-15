package com.gls.ripple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gls.ripple.adapter.AccountAdapter;
import com.gls.ripple.adapter.BalanceAdapter;
import com.gls.ripple.response.Account;
import com.gls.ripple.response.ConfirmPaymentResponse;
import com.gls.ripple.response.PreparePaymentResponse;
import com.gls.ripple.response.SubmitPaymentData;
import com.gls.ripple.response.SubmitPaymentResponse;
import com.gls.ripple.response.UuidResponse;
import com.gls.ripple.url.Url;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PaymentActivity extends BaseActivity {
    ListView account_list;
    ArrayList<Account> accounts;
    RelativeLayout oldChecked = null;
    Account selectedAccount = null;
    Spinner pay_currency;
    EditText pay_amount;
    String UUID = "";
    String amount;
    String currency;
    final String SECRET = "snszzMy5tDaU61gjj2hmrtRKSgtXc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        account_list = (ListView) findViewById(R.id.account_list);
        pay_currency = (Spinner) findViewById(R.id.pay_currency);
        pay_amount = (EditText) findViewById(R.id.pay_amount);

        ArrayAdapter currencyAdapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_row, HomeActivity.balances);
        pay_currency.setAdapter(currencyAdapter);

        accounts = new ArrayList<>();
        accounts.add(new Account("Jorden", "rUoLM8DSDozPmRwXzbYpusf2xLcNtFnjeN"));
        accounts.add(new Account("Santosh", "rUoLM8DSDozPmRwXzbYpusf2xLcNtFnjeN"));
        accounts.add(new Account("Giant Leap Systems", "rUoLM8DSDozPmRwXzbYpusf2xLcNtFnjeN"));
        AccountAdapter adapter = new AccountAdapter(getApplicationContext(), R.layout.account_row, accounts);
        account_list.setAdapter(adapter);
        account_list.setOnItemClickListener(itemClicked);
    }

    AdapterView.OnItemClickListener itemClicked = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (oldChecked != null) {
                oldChecked.findViewById(R.id.logo_text_selected).setVisibility(View.GONE);
                oldChecked.findViewById(R.id.logo_text).setVisibility(View.VISIBLE);
            }
            oldChecked = (RelativeLayout) view;
            oldChecked.findViewById(R.id.logo_text_selected).setVisibility(View.VISIBLE);
            oldChecked.findViewById(R.id.logo_text).setVisibility(View.GONE);
            selectedAccount = (Account) view.getTag();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return true;
    }

    public void makePayment(View v) {
        amount = pay_amount.getText().toString();
        currency = pay_currency.getSelectedItem().toString();
        if (amount.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_SHORT).show();
            pay_amount.requestFocus();
            return;
        }
        if (selectedAccount == null) {
            Toast.makeText(getApplicationContext(), "Please Select Account", Toast.LENGTH_SHORT).show();
            return;
        }

        new LoadData(new Url(getApplicationContext()).getUuidUrl(), "", this, Finals.UUID).execute();
    }

    @Override
    public void onGetResponse(String response, String callfor) {
        Log.e("####Response", response + "");
    try {
        if (callfor.equals(Finals.UUID)) {
            UuidResponse uuid = new Gson().fromJson(response, UuidResponse.class);
            if (uuid.isSuccess()) {
                UUID = uuid.getUuid();
                new LoadData(new Url(getApplicationContext()).getPrepatePaymentUrl(selectedAccount, amount, currency), "", this, Finals.PREPARE_PAYMENT).execute();
            } else {
                throwError();
            }
        }
        if (callfor.equals(Finals.PREPARE_PAYMENT)) {
            PreparePaymentResponse pp = new Gson().fromJson(response, PreparePaymentResponse.class);
            if (pp.isSuccess()) {
                SubmitPaymentData data = new SubmitPaymentData();
                data.setClient_resource_id(UUID);
                data.setSecret(SECRET);
                data.setPayment(pp.getPayments().get(0));
                new LoadData(new Url(getApplicationContext()).getSubnitPaymentUrl(), new Gson().toJson(data), this, Finals.SUBMIT_PAYMENT).execute();
            } else {
                throwError();
            }
        }
        if (callfor.equals(Finals.SUBMIT_PAYMENT)) {
            SubmitPaymentResponse submit = new Gson().fromJson(response, SubmitPaymentResponse.class);
            if (submit.isSuccess()) {
                new LoadData(new Url(getApplicationContext()).getConfirmPaymentUrl(submit.getHash()), "", this, Finals.CONFIRM_PAYMENT).execute();
            } else {
                throwError();
            }
        }
        if (callfor.equals(Finals.CONFIRM_PAYMENT)) {
            ConfirmPaymentResponse confirm = new Gson().fromJson(response, ConfirmPaymentResponse.class);
            if (confirm.isSuccess()) {
                Toast.makeText(getApplicationContext(), "Payment Successful", Toast.LENGTH_SHORT).show();
                onBackPressed();
            } else {
                throwError();
            }
        }
    }catch (Exception e){
        e.printStackTrace();
        throwError();
    }
}

    public void throwError(){
        Toast.makeText(getApplicationContext(), "Something Wrong With Server", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}
