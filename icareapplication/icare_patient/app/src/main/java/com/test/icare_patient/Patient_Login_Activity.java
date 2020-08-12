package com.test.icare_patient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.test.icare_patient.create_account.Create_Account_Activity;
import com.test.icare_patient.home_pkg.HomeActivity;
import com.test.icare_patient.model.UserInfo;
import com.test.icare_patient.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Patient_Login_Activity extends AppCompatActivity implements View.OnClickListener {
 ImageView id_back12; TextView iv_forgetpass,signup;
 Button btn_login; View id_toolbar;
    TextInputEditText tv_mobile,tv_password;
    ProgressDialog pd;
    private static Animation shakeAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        id_toolbar = findViewById(R.id.id_toolbar);
        id_back12 = id_toolbar.findViewById(R.id.id_back);
        btn_login = findViewById(R.id.btn_login);
        iv_forgetpass = findViewById(R.id.iv_forgetpass);
        signup = findViewById(R.id.signup);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_password = findViewById(R.id.tv_password);
        id_back12.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        iv_forgetpass.setOnClickListener(this);
        signup.setOnClickListener(this);

        pd = new ProgressDialog(Patient_Login_Activity.this, R.style.AppCompatAlertDialogStyle);
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
    }
    private void validation(View v) {
        if (tv_mobile.getText().toString().isEmpty()) {
            new CustomToast().Show_Toast(this, v, "Email Can't Empty");
            tv_mobile.startAnimation(shakeAnimation);
            tv_mobile.getBackground().mutate().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            tv_mobile.requestFocus();
        } else if (!Constant.isValidEmail(tv_mobile.getText().toString())) {
            new CustomToast().Show_Toast(this, v, "Invalid Email");
            tv_mobile.startAnimation(shakeAnimation);
            tv_mobile.getBackground().mutate().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            tv_mobile.requestFocus();
        }else if (tv_password.getText().toString().isEmpty()) {
            new CustomToast().Show_Toast(this, v, "Password Can't Empty");
            tv_password.startAnimation(shakeAnimation);
            tv_password.getBackground().mutate().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            tv_password.requestFocus();
        } else if (tv_password.getText().toString().length() <= 6) {
            new CustomToast().Show_Toast(this, v, "Password digits must be greater than six");
            tv_password.startAnimation(shakeAnimation);
            tv_password.getBackground().mutate().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            tv_password.requestFocus();
        } else if (CheckNetwork.isNetAvailable(this)) {
            String mobile = "";
            String password = tv_password.getText().toString();
            String email = tv_mobile.getText().toString();
            doctore_Login(mobile, password,email);
        } else {
            new CustomToast().Show_Toast(this, v, getString(R.string.plz_check_your_intrenet_text));
        }
    }

    public void doctore_Login(String mobile, String password, String email) {
        if (Constant.isNetworkAvailable(getApplicationContext())) {
            pd.setMessage("loading");
            pd.show();
            UserInfo userInfo = new UserInfo();
            userInfo.setPhone_number("8018520000");
            userInfo.setEmail(email);
            userInfo.setPassword(password);
            userInfo.setLogin_type("2");
            userInfo.setFirebase_token("vgvjgvjdgvjfdgvjdfgbvjdf");
            Log.e("TAG", "login request : " + new Gson().toJson(userInfo));
            (ApiClient.getClient().patient_login(userInfo)).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    pd.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            Log.e("TAG", "login response : " + new Gson().toJson(response.body()));
                            String repmsg = String.valueOf(response.body().get("status"));
                            String message = (response.body().get("message").toString());
                            String without_quotes = message.replace("\"", "");

                            if (repmsg.equals("true")) {
                                Toast.makeText(Patient_Login_Activity.this, without_quotes, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Patient_Login_Activity.this, HomeActivity.class));
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                                finish();
                            }
                            else{
                                Toast.makeText(Patient_Login_Activity.this, without_quotes, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    pd.dismiss();
                    Toast.makeText(Patient_Login_Activity.this, getString(R.string.server_errors), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            pd.dismiss();
            Toast.makeText(getApplicationContext(), getString(R.string.plz_check_your_intrenet_text), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup:
                startActivity(new Intent(Patient_Login_Activity.this, Create_Account_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.btn_login:
                validation(v);
               /* startActivity(new Intent(Patient_Login_Activity.this, HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                finish();*/
                break;

            case R.id.iv_forgetpass:
                startActivity(new Intent(Patient_Login_Activity.this, Forget_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
