package com.gls.ripple.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gls.ripple.R;
import com.gls.ripple.response.Balance;

import java.util.ArrayList;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class BalanceAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Balance> list;
    LayoutInflater inflater;
    public BalanceAdapter(Context context, int resource, ArrayList<Balance> list) {
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
        ((TextView)row.findViewById(R.id.amount)).setText(list.get(position).getValue()+"");
        ((TextView)row.findViewById(R.id.currency)).setText(list.get(position).getCurrency()+"");
        return row;
    }
}
