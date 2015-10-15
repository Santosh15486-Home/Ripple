package com.gls.ripple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.gls.ripple.adapter.HistoryAdapter;
import com.gls.ripple.response.ConfirmPaymentResponse;
import com.gls.ripple.response.HistoryResponse;
import com.gls.ripple.response.PreparePaymentResponse;
import com.gls.ripple.response.SubmitPaymentData;
import com.gls.ripple.response.SubmitPaymentResponse;
import com.gls.ripple.response.UuidResponse;
import com.gls.ripple.url.Url;
import com.google.gson.Gson;

public class HistoryActivity extends BaseActivity {
    ListView history_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        history_list = (ListView) findViewById(R.id.history_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new LoadData(new Url(getApplicationContext()).getHistoryUrl(),"",this, Finals.HISTORY).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }
        if (id == R.id.action_refresh) {
            new LoadData(new Url(getApplicationContext()).getHistoryUrl(),"",this, Finals.HISTORY).execute();
        }
        return true;
    }

    @Override
    public void onGetResponse(String response, String callfor) {
        Log.e("####Response", response + "");
        try {
            if (callfor.equals(Finals.HISTORY)) {
                HistoryResponse history = new Gson().fromJson(response,HistoryResponse.class);
                if(history.isSuccess()){
                    HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(),R.layout.history_row,history.getPayments());
                    history_list.setAdapter(adapter);
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
