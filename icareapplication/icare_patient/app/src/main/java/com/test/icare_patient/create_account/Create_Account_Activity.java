package com.test.icare_patient.create_account;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.test.icare_patient.Admin_Confirmation_Activity;
import com.test.icare_patient.OTP_Activity;
import com.test.icare_patient.Patient_Login_Activity;
import com.test.icare_patient.R;

public class Create_Account_Activity extends AppCompatActivity  implements View.OnClickListener{
Button btn_registration;
    ImageView id_back; TextView signin;
    View id_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_fragment_patient_signup);
        addTabs();
    }

    private void addTabs() {
        id_toolbar = findViewById(R.id.id_toolbar);
        id_back = id_toolbar.findViewById(R.id.id_back);
        signin = findViewById(R.id.signin);
        id_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_registration = findViewById(R.id.btn_registration);
        btn_registration.setOnClickListener(this);
        signin.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin:
                startActivity(new Intent(Create_Account_Activity.this, Patient_Login_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                finish();
                break;

            case R.id.btn_registration:
                startActivity(new Intent(Create_Account_Activity.this, OTP_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                finish();
                break;
        }
    }
}
