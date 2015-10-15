package com.gls.ripple;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                goToHome();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void goToHome(){
        Intent homeIntent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public void onBackPressed() {

    }
}
