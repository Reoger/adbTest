package com.example.cm.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by CM on 2018/1/17.
 */
public class MyService extends Service {


    private Thread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Log.d("TAG", "service已经启动了 "+i);
                    try {
                        Thread.sleep(888);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }




    @Override
    public void onDestroy() {
        Log.d("TAG", "onDestroy: 接收到销毁服务的消息");
        thread.interrupt();
        super.onDestroy();
    }
}
