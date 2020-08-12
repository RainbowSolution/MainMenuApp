package com.test.icare_patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUs_Activity extends AppCompatActivity  implements View.OnClickListener{
    ImageView iv_back;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        tv_title.setText("Contact Us");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(new Intent(ContactUs_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
