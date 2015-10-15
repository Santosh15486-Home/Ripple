package com.gls.ripple.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gls.ripple.R;
import com.gls.ripple.response.Account;
import com.gls.ripple.response.SubmitPaymentResponse;

import java.util.ArrayList;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class HistoryAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SubmitPaymentResponse> list;
    LayoutInflater inflater;
    public HistoryAdapter(Context context, int resource, ArrayList<SubmitPaymentResponse> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(resource,null);
        ((TextView)row.findViewById(R.id.name)).setText("");
        ((TextView)row.findViewById(R.id.incoming)).setText("");
        ((TextView)row.findViewById(R.id.account_id)).setText("");
        row.setTag(list.get(position));
        return row;
    }
}