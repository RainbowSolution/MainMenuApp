package com.test.icare_patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.test.icare_patient.home_pkg.HomeActivity;

public class Admin_Confirmation_Activity extends AppCompatActivity implements View.OnClickListener {
    Button btn_refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confim);

        initView();

    }

    private void initView() {
        btn_refresh = findViewById(R.id.btn_refresh);
        btn_refresh.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_refresh:
                startActivity(new Intent(Admin_Confirmation_Activity.this, HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                finishAffinity();
                break;
        }
    }
}
