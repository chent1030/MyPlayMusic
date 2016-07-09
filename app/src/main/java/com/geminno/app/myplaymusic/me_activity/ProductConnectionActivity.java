package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class ProductConnectionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_product_conn;
    private ImageButton ib_production_delete;
    private EditText et_product_conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_connection);

        ib_product_conn = ((TextView) findViewById(R.id.ib_product_conn));
        ib_production_delete = ((ImageButton) findViewById(R.id.ib_production_delete));
        et_product_conn= ((EditText) findViewById(R.id.et_product_conn));
        ib_product_conn.setOnClickListener(this);
        ib_production_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_product_conn:
                this.finish();
                break;
            case R.id.ib_production_delete:
                et_product_conn.setText("");
                break;
        }
    }
}
