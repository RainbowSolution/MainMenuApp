package com.test.icare_patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.test.icare_patient.search_doctor.Patient_SearchDoctorActivity;


public class Patient_SearchDoctorDashboard_Activity extends AppCompatActivity implements View.OnClickListener {
 AppCompatImageView iv_back;
    private RelativeLayout rl_notification,ivSbSpector, ivSbSpecialty, ivSbS, ivSbC, ivSbN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_search_doctor_dashboard_);
        init();
    }

    private void init() {

        rl_notification = findViewById(R.id.rl_notification);
        iv_back = findViewById(R.id.id_back);
        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);


        ivSbSpector = findViewById(R.id.ivSbSpectorId);
        ivSbSpecialty = findViewById(R.id.ivSbSpecialtyId);
        ivSbS = findViewById(R.id.ivSbSId);
        ivSbC = findViewById(R.id.ivSbCId);
        ivSbN = findViewById(R.id.ivSbNId);

        ivSbSpector.setOnClickListener(this);
        ivSbSpecialty.setOnClickListener(this);
        ivSbS.setOnClickListener(this);
        ivSbC.setOnClickListener(this);
        ivSbN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
            case R.id.ivSbSpectorId:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Patient_SearchDoctorActivity.class));
                break;
            case R.id.ivSbSpecialtyId:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Patient_SearchDoctorActivity.class));
                break;
            case R.id.ivSbSId:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Patient_SearchDoctorActivity.class));
                break;
            case R.id.ivSbCId:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Patient_SearchDoctorActivity.class));
                break;
            case R.id.ivSbNId:
                startActivity(new Intent(Patient_SearchDoctorDashboard_Activity.this, Patient_SearchDoctorActivity.class));
                break;


        }
    }
}
