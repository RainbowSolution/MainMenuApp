package com.test.icare_patient.doctor_detail_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.icare_patient.Notification_Activity;
import com.test.icare_patient.R;

public class DoctorDetailActivity extends AppCompatActivity implements Doctor_Detail_Appointment_Adapter.OnClick{
    private RecyclerView rvAppointmentBooking;
    private Doctor_Detail_Appointment_Adapter doctor_detail_appointment_adapter;
    private LinearLayoutManager linearLayoutManager;

    ImageView iv_back;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_activity_doctor_detail);
        init();
    }

    private void init() {
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        tv_title.setText("Doctor Details");

        rl_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailActivity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });


        rvAppointmentBooking = findViewById(R.id.rvAppointmentBookingId);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        rvAppointmentBooking.setLayoutManager(linearLayoutManager);
        doctor_detail_appointment_adapter = new Doctor_Detail_Appointment_Adapter(getApplicationContext(), this);
        rvAppointmentBooking.setAdapter(doctor_detail_appointment_adapter);
    }

    @Override
    public void onClick(View view, int position) {

    }
}
