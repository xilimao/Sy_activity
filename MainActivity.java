package com.example.sxhs.sy_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String sex1;
    String name1;
    String pwd1;
    private Button btn1;
    private EditText getName;
    private EditText getPwd;
    private CheckBox getBoy;
    private CheckBox getGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.subXinxi);
        getName = (EditText) findViewById(R.id.getName);
        getPwd = (EditText) findViewById(R.id.getPassWord);
        getBoy = (CheckBox) findViewById(R.id.boy);
        getGirl = (CheckBox) findViewById(R.id.gril);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name1 = getName.getText().toString();
                pwd1 = getPwd.getText().toString();

                boolean geBoy = getBoy.isChecked();
                boolean geGirl = getGirl.isChecked();
                pdbg(geBoy, geGirl);

                Intent intent = new Intent();
                intent.putExtra("name", name1);
                intent.putExtra("pwd", pwd1);
                intent.putExtra("sex", sex1);
                intent.setClass(MainActivity.this, TextActivity.class);
                // startActivity(intent);
                startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String string = data.getExtras().getString("name");

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT);
    }

    public void pdbg(boolean b, boolean g) {
        if ((b == true) && (g == false)) {
            sex1 = getBoy.getText().toString();
        } else if ((b == false) && (g == true)) {
            sex1 = getGirl.getText().toString();
        }
    }
}
