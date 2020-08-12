package com.test.icare_patient.patient_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.test.icare_patient.ContactUs_Activity;
import com.test.icare_patient.Patient_SearchDoctorDashboard_Activity;
import com.test.icare_patient.R;
import com.test.icare_patient.appointment_pkg.MyAppointment_Activity;
import com.test.icare_patient.patient.Dialog_Book_AppointmentFragment;

public class Patient_HomeFragment extends Fragment implements Doctor_List_Adapter.OnClick, View.OnClickListener {
    View v;
    private ViewPager vpHomeBanner;
    private TabLayout tlHomeBanner;
    private CardView cvSearchDoctor, cvBookAppointment, cvMyAppointment, cvContactUs;
    private RecyclerView rvDoctorList;
    private LinearLayoutManager linearLayoutManager;
    private Doctor_List_Adapter doctor_list_adapter;
    private Pateint_Banner_Adapter pateint_banner_adapter;
    AppCompatTextView tvViewAllId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_patient_dashboard, container, false);
        init(v);

        return v;
    }

    private void init(View view) {
        rvDoctorList = view.findViewById(R.id.rvDoctorListId);
        cvSearchDoctor = view.findViewById(R.id.cvSearchDoctorId);
        cvBookAppointment = view.findViewById(R.id.cvBookAppointmentId);
        cvMyAppointment = view.findViewById(R.id.cvMyAppointmentId);
        cvContactUs = view.findViewById(R.id.cvContactUsId);
        tvViewAllId = view.findViewById(R.id.tvViewAllId);


        cvSearchDoctor.setOnClickListener(this);
        cvBookAppointment.setOnClickListener(this);
        cvMyAppointment.setOnClickListener(this);
        cvContactUs.setOnClickListener(this);
        tvViewAllId.setOnClickListener(this);


        vpHomeBanner = view.findViewById(R.id.vpHomeBannerId);
        tlHomeBanner = view.findViewById(R.id.tlHomeBannerId);
        pateint_banner_adapter = new Pateint_Banner_Adapter(getContext());
        vpHomeBanner.setAdapter(pateint_banner_adapter);
        tlHomeBanner.setupWithViewPager(vpHomeBanner);


        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, true);
        rvDoctorList.setLayoutManager(linearLayoutManager);
        doctor_list_adapter = new Doctor_List_Adapter(getContext(), this);
        rvDoctorList.setAdapter(doctor_list_adapter);


    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvViewAllId:
                startActivity(new Intent(getContext(), Patient_SearchDoctorDashboard_Activity.class));
                break;
            case R.id.cvSearchDoctorId:
                startActivity(new Intent(getContext(), Patient_SearchDoctorDashboard_Activity.class));
                break;
            case R.id.cvBookAppointmentId:
                FragmentManager fm = getFragmentManager();
                Dialog_Book_AppointmentFragment dialogFragment = new Dialog_Book_AppointmentFragment ();
                dialogFragment.show(fm, "Sample Fragment");
                break;
            case R.id.cvMyAppointmentId:
                startActivity(new Intent(getContext(), MyAppointment_Activity.class));
                break;
            case R.id.cvContactUsId:
                startActivity(new Intent(getContext(), ContactUs_Activity.class));
                break;


        }
    }


}

