package com.eup.androidadvancedemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class NetWordChangeReceiver extends BroadcastReceiver {
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        String status = NetworkUtil.getConnectivityStatusString(context);

        Log.e("Receiver ", "" + status);

        if (status.equals("Not connected to Internet")) {
            Toast.makeText(context,"Netwotd is turned OFF",Toast.LENGTH_SHORT).show();
            Log.e("Receiver ", "not connction");// your code when internet lost


        } else {
            Toast.makeText(context,"Netwotd is turned ON",Toast.LENGTH_SHORT).show();
            Log.e("Receiver ", "connected to internet");//your code when internet connection come back
        }

    }
}
