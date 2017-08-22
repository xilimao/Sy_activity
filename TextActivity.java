package com.example.sxhs.sy_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by sxhs on 2017/8/22.
 */

public class TextActivity extends AppCompatActivity {

    private TextView userName;
    private TextView userPwd;
    private TextView userSex;
    private Button btn2;
    String sex;
    String name;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        userName = (TextView) findViewById(R.id.userName);
        userPwd = (TextView) findViewById(R.id.userPwd);
        userSex = (TextView) findViewById(R.id.userSex);
        btn2 = (Button) findViewById(R.id.btn2);

        final Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pwd = intent.getStringExtra("pwd");
        sex = intent.getStringExtra("sex");

        userName.setText(name);
        userPwd.setText(pwd);
        userSex.setText(sex);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("name","hhhhh");
                TextActivity.this.setResult(2,intent2);
                TextActivity.this.finish();
            }
        });

    }
}
