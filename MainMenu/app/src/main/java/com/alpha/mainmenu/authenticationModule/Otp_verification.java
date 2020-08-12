package com.alpha.mainmenu.authenticationModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.alpha.mainmenu.R;

import com.alpha.mainmenu.food_pkg.FoodActivity;
import com.alpha.mainmenu.utility.CheckNetwork;

public class Otp_verification extends AppCompatActivity implements View.OnClickListener {
    private AppCompatImageView ivBackForgetId;
    private LinearLayout liresendotpMainId,lieditNumberid;
    private AppCompatButton btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_otp);
        //   apiServices = RetrofitClient.getClient().create(ApiServices.class);
        // init();

        ivBackForgetId = findViewById(R.id.ivBackForgetId);
         liresendotpMainId = findViewById(R.id.liresendotpMainId);
        lieditNumberid = findViewById(R.id.lieditNumberid);
        btn_send = findViewById(R.id.btn_send);
        ivBackForgetId.setOnClickListener(this);
        liresendotpMainId.setOnClickListener(this);
        lieditNumberid.setOnClickListener(this);
        btn_send.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBackForgetId:
                CheckNetwork.backScreenWithFinis(Otp_verification.this);
                break;
            case R.id.lieditNumberid:
                CheckNetwork.backScreenWithFinis(Otp_verification.this);
                break;
            case R.id.liresendotpMainId:
                Toast.makeText(this, "working..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_send:
                startActivity(new Intent(Otp_verification.this, FoodActivity.class));
                finishAffinity();
                break;
        }
    }
}
