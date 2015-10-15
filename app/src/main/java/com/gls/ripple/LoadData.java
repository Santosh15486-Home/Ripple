package com.gls.ripple;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.gls.ripple.server.ServerConnection;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class LoadData extends AsyncTask {
    String url;
    String result = "";
    String callfor = "";
    String data = "";
    BaseActivity activity;
    ProgressDialog progressDialog;

    public LoadData(String url, String data, BaseActivity activity, String callfor){
        this.url = url;
        this.activity = activity;
        this.callfor = callfor;
        this.data = data;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(activity,"","Loading...");
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            Log.e("URL doInBackground",url);
            if (data == null || data.equals("")) {
                result = ServerConnection.executeGet(url);
            } else {
                result = ServerConnection.executePost(data, url);
            }
        } catch (Exception e){
            Log.e("Error doInBackground",e.toString());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
        activity.onGetResponse(result,callfor);
    }
}
