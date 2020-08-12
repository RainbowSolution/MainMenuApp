package com.test.icare_patient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Activity.this,Patient_Login_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                finish();
                //Do something after 100ms
            }
        }, 2000);
    }
}
