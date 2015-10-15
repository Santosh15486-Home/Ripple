package com.gls.ripple;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gls.ripple.adapter.BalanceAdapter;
import com.gls.ripple.response.Balance;
import com.gls.ripple.response.BalanceResponse;
import com.gls.ripple.response.GetSettingResponse;
import com.gls.ripple.url.Url;
import com.google.gson.Gson;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity {
    LinearLayout errorContainer;
    RelativeLayout accountContainer;
    ListView balance_list;
    public static ArrayList<Balance> balances;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            String code = getIntent().getStringExtra("EXIT");
            if(code.equals("yes")){
                this.finish();
                return;
            }
        }catch (Exception e){}
        setContentView(R.layout.activity_home);
        errorContainer = (LinearLayout)findViewById(R.id.error_container);
        accountContainer = (RelativeLayout) findViewById(R.id.account_container);
        balance_list = (ListView)findViewById(R.id.balance_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new LoadData(new Url(getApplicationContext()).getSettingUrl(),"",this, Finals.CHECK_ID).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_notification) {
            return true;
        } else if (id == R.id.action_settings) {
            Intent setting = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(setting);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
        alert.setMessage("Are you sure exit from application?");
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent exitApp=new Intent(getApplicationContext(), HomeActivity.class);
                exitApp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                exitApp.putExtra("EXIT","yes");
                startActivity(exitApp);
            }
        });
        alert.show();
    }

    @Override
    public void onGetResponse(String response, String callfor) {
        Log.e("####Response",response+"");
        try {
            if (callfor.equals(Finals.CHECK_ID)) {
                try {
                    GetSettingResponse settings = new Gson().fromJson(response, GetSettingResponse.class);
                    if (settings.isSuccess()) {
                        accountContainer.setVisibility(View.VISIBLE);
                        errorContainer.setVisibility(View.GONE);
                        loadBalabces();
                    } else {
                        accountContainer.setVisibility(View.GONE);
                        errorContainer.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    accountContainer.setVisibility(View.GONE);
                    errorContainer.setVisibility(View.VISIBLE);
                }
            }
            if (callfor.equals(Finals.BALANCES)) {
                try {
                    BalanceResponse balance = null;
                    balance = new Gson().fromJson(response, BalanceResponse.class);
                    if(balance.isSuccess()) {
                        setBalanceList(balance);
                    } else {
                        Toast.makeText(getApplicationContext(), "Something Wrong With Server", Toast.LENGTH_SHORT).show();
                        accountContainer.setVisibility(View.GONE);
                        errorContainer.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        } catch (Exception e){
            accountContainer.setVisibility(View.GONE);
            errorContainer.setVisibility(View.VISIBLE);
        }
    }

    public void openSetting(View v){
        Intent setting = new Intent(getApplicationContext(), SettingActivity.class);
        startActivity(setting);

    }

    public void loadBalabces(){
        new LoadData(new Url(getApplicationContext()).getBalancesUrl(),"",this, Finals.BALANCES).execute();
    }

    public void setBalanceList(BalanceResponse balance){
        try {
            if (balance != null) {
                if (balance.getBalances().size() > 0) {
                    balances = balance.getBalances();
                    BalanceAdapter adapter = new BalanceAdapter(getApplicationContext(),R.layout.balance_row,balance.getBalances());
                    balance_list.setAdapter(adapter);
                }
            }
        }catch (Exception e){}
    }

    public void payMoney(View v){
        Intent payIntent = new Intent(getApplicationContext(),PaymentActivity.class);
        startActivity(payIntent);
    }

    public void showHistory(View v){
//        Intent payIntent = new Intent(getApplicationContext(),HistoryActivity.class);
//        startActivity(payIntent);
    }
}
