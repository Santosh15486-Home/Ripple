package com.gls.ripple.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gls.ripple.R;
import com.gls.ripple.response.Account;
import com.gls.ripple.response.Balance;

import java.util.ArrayList;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class AccountAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Account> list;
    LayoutInflater inflater;
    public AccountAdapter(Context context, int resource, ArrayList<Account> list) {
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
        ((TextView)row.findViewById(R.id.name)).setText(list.get(position).getName()+"");
        ((TextView)row.findViewById(R.id.logo_text)).setText(list.get(position).getName().substring(0,1)+"");
        ((TextView)row.findViewById(R.id.account_id)).setText(list.get(position).getAccountID()+"");
        row.setTag(list.get(position));
        return row;
    }
}