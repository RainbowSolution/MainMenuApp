package com.test.icare_patient.search_doctor;

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

public class Patient_SearchDoctorActivity extends AppCompatActivity implements Search_Doctor_Adapter.OnClick, View.OnClickListener {

    private LinearLayoutManager setLayoutManager;
    private RecyclerView rvSearchDoctorList;
    private Search_Doctor_Adapter search_doctor_adapter;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification; ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_activity_search_doctor);
        init();

    }

    private void init() {
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        tv_title.setText("Search Doctor");

        rvSearchDoctorList = findViewById(R.id.rvSearchDoctorListId);
        setLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, true);
        rvSearchDoctorList.setLayoutManager(setLayoutManager);
        search_doctor_adapter = new Search_Doctor_Adapter(getApplicationContext(), this);
        rvSearchDoctorList.setAdapter(search_doctor_adapter);
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(new Intent(Patient_SearchDoctorActivity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
