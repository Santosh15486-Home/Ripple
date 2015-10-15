package com.gls.ripple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gls.ripple.User.UserDetails;

public class SettingActivity extends AppCompatActivity {
    EditText user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user_id = (EditText)findViewById(R.id.user_id);
        user_id.setText(UserDetails.getID(getApplicationContext()));
    }

    public void saveID(View v){
        if(user_id.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Enter ID",Toast.LENGTH_SHORT).show();
        } else {
            UserDetails.setID(getApplicationContext(),user_id.getText().toString());
            Toast.makeText(getApplicationContext(),"ID Saved",Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}
