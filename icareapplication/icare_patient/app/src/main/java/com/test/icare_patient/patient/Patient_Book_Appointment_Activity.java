package com.test.icare_patient.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.icare_patient.Notification_Activity;
import com.test.icare_patient.R;


public class Patient_Book_Appointment_Activity extends AppCompatActivity  implements View.OnClickListener{
    ImageView iv_back;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification; Button btn_booknow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_book_appointment);

        btn_booknow = findViewById(R.id.btn_booknow);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        btn_booknow.setOnClickListener(this);

        tv_title.setText("Book For Me");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_booknow:
                startActivity(new Intent(Patient_Book_Appointment_Activity.this, Patient_Confirm_Booking_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.rl_notification:
                startActivity(new Intent(Patient_Book_Appointment_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
