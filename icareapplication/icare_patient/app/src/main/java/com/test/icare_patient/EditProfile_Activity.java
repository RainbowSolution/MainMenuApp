package com.test.icare_patient;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;

import com.test.icare_patient.home_pkg.HomeActivity;

public class EditProfile_Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    ImageView iv_back;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification;
    AppCompatSpinner sp_gender;
    private String[] Gender;
    Button btn_deletaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        btn_deletaccount = findViewById(R.id.btn_deletaccount);
        sp_gender = findViewById(R.id.sp_gender);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        Gender  = new String[]{getResources().getString(R.string.gender), "Male", "Female"};
        genderspinner();
        tv_title.setText("Edit Profile");

        btn_deletaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteaccount_dialog();
            }
        });
    }

    public void deleteaccount_dialog() {
        final Dialog dialog = new Dialog(EditProfile_Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_delete_account);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        AppCompatImageView rllogout = dialog.findViewById(R.id.ivlogoutCloseId);
        Button btn_cancel_booking = dialog.findViewById(R.id.btn_cancel_booking);
        btn_cancel_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
            }
        });

        rllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private void genderspinner() {
        sp_gender.setOnItemSelectedListener(EditProfile_Activity.this);
        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item, Gender);
        aa.setDropDownViewResource(R.layout.spinner_item);
        sp_gender.setAdapter(aa);
        sp_gender.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                try {
                    if (sp_gender.getSelectedItem().toString().equals(getApplicationContext().getResources().getString(R.string.gender))) {

                        ((TextView) sp_gender.getSelectedView()).setTextColor(getApplicationContext().getResources().getColor(R.color.gray_clr));

                    } else {
                        ((TextView) sp_gender.getSelectedView()).setTextColor(Color.BLACK);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(new Intent(EditProfile_Activity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
