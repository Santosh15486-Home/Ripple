package com.gls.ripple.User;


import android.content.Context;
import android.content.SharedPreferences;

import com.gls.ripple.Finals;

/**
 * Created by Santosh on 02-Jul-15.
 */
public class UserDetails {

    public static String getID(Context context){
        SharedPreferences sp = context.getSharedPreferences(Finals.SP, Context.MODE_PRIVATE);
        return sp.getString(Finals.R_ID,"rKQmq9RpJtrFR7cx5HbxxSYijjTcHcu7PE");
    }
    public static void setID(Context context,String state){
        SharedPreferences sp = context.getSharedPreferences(Finals.SP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Finals.R_ID,state);
        editor.commit();
    }
}
