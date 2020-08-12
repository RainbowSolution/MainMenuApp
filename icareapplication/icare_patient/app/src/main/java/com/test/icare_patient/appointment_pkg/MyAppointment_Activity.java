package com.test.icare_patient.appointment_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.test.icare_patient.Notification_Activity;
import com.test.icare_patient.R;


public class MyAppointment_Activity extends AppCompatActivity implements View.OnClickListener {
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification;
    private ViewPager vpBookingHistory;
    private TabLayout tabLayoutBooking;
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_activity_booking_history);
        init();
    }

    private void init() {
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        tv_title.setText("Booking History");

        vpBookingHistory = findViewById(R.id.vpBookingHistoryId);
        tabLayoutBooking = findViewById(R.id.tabLayoutBookingId);
        tabLayoutBooking.setupWithViewPager(vpBookingHistory);
        BookingHistorySliderAdapter adapter = new BookingHistorySliderAdapter(getSupportFragmentManager());
        adapter.addFrag(new Current_Booking_History_Fragment(), getResources().getString(R.string.current));
        adapter.addFrag(new Cancel_Booking_History_Fragment(), getResources().getString(R.string.canceled));
        vpBookingHistory.setAdapter(adapter);
        vpBookingHistory.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 1) {

                }
            }

            @Override
            public void onPageSelected(int position) {
                vpBookingHistory.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(new Intent(MyAppointment_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
