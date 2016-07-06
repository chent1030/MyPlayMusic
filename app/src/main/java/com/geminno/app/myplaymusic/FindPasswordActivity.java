package com.geminno.app.myplaymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPasswordActivity extends AppCompatActivity {

    private Button btn_close;
    private Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);

        btn_close = ((Button) findViewById(R.id.btn_close));
        btn_return = ((Button) findViewById(R.id.btn_return));

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindPasswordActivity.this,MainActivity.class);
                startActivity(intent);
               FindPasswordActivity.this.finish();
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindPasswordActivity.this,MainActivity.class);

                startActivity(intent);

                FindPasswordActivity.this.finish();
            }
        });
    }
}
