package com.example.cm.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by CM on 2018/1/17.
 */
public class MyBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"我接收到通知了",Toast.LENGTH_SHORT).show();
        Log.d("TAG", "onReceive: ");
    }
}
