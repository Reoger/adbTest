package com.example.cm.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {


    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        IntentFilter intentFilter = new IntentFilter("com.android.broadcast.test");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String str = intent.getStringExtra("adb_extra");
                if(str == null)
                    str = "未接收来自adb的信息";
                Toast.makeText(context,"动态广播，利用adb命令唤起"+str,Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onReceive: "+str);
            }
        };
        registerReceiver(broadcastReceiver,intentFilter);

        Intent intent = getIntent();
        String hello;
        int a = intent.getIntExtra("pid",0);
        if(intent != null)
            hello = intent.getStringExtra("extra");
        else
            hello = "not receive";
        ((TextView)findViewById(R.id.show_info)).setText("info = "+hello+" ,pid= "+a);



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
