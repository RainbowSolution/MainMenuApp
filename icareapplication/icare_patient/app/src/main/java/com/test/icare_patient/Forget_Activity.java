package com.test.icare_patient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forget_Activity extends AppCompatActivity implements View.OnClickListener {
 ImageView id_back;
 Button btn_submit; View id_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        initView();
    }

    private void initView() {
        id_toolbar = findViewById(R.id.id_toolbar);
        id_back = id_toolbar.findViewById(R.id.id_back);
        btn_submit = findViewById(R.id.btn_submit);
        id_back.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
            case R.id.btn_submit:
                Toast.makeText(getApplicationContext(),"Under Working",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
