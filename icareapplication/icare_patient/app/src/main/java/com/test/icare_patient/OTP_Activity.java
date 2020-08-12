package com.test.icare_patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.icare_patient.create_account.Create_Account_Activity;
import com.test.icare_patient.home_pkg.HomeActivity;

public class OTP_Activity extends AppCompatActivity implements View.OnClickListener {
 ImageView id_back;
 Button btn_verifynow; View id_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        initView();
    }

    private void initView() {
        id_toolbar = findViewById(R.id.id_toolbar);
        id_back = id_toolbar.findViewById(R.id.id_back);
        btn_verifynow = findViewById(R.id.btn_verifynow);
        id_back.setOnClickListener(this);
        btn_verifynow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.btn_verifynow:
                startActivity(new Intent(OTP_Activity.this, HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
