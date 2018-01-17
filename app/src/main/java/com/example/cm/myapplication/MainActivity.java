package com.example.cm.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.add_share_preferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initView();
            }
        });

        findViewById(R.id.next_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putExtra("extra"," i am a message from MainActivity");
                startActivity(intent);
            }
        });


        findViewById(R.id.send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.android.broadcast.test");
                sendBroadcast(intent);
            }
        });


        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);
                Toast.makeText(MainActivity.this, "服务已经成功启动", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {

        SharedPreferences sharedPreferences = getSharedPreferences("ljq", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器

        editor.putString("name", "reoger");

        editor.putInt("age", 24);

        editor.commit();//提交修改

    }


}
