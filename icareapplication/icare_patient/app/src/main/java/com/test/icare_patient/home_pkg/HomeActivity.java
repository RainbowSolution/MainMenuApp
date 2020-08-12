package com.test.icare_patient.home_pkg;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.test.icare_patient.EditProfile_Activity;
import com.test.icare_patient.Notification_Activity;
import com.test.icare_patient.Patient_Help_Activity;
import com.test.icare_patient.Patient_Login_Activity;
import com.test.icare_patient.R;
import com.test.icare_patient.SettingsMain;
import com.test.icare_patient.appointment_pkg.MyAppointment_Activity;
import com.test.icare_patient.patient.Patient_Aboutus_Activity;
import com.test.icare_patient.patient_home.Patient_HomeFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvSelectorADoctor;
    NavigationExpandableListAdapter navigationExpandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    AppCompatImageView ivLogoHomeId, ivserachHomeId, ivnoticationHomeId;
    DrawerLayout drawer;
    NavigationView navigationView;
    private AppCompatTextView tvUserName, tvEmail, ivNofificationcoutId, tvhomeId;
    private String Type_id, username, useremail, userimage, patient_id;
    private RelativeLayout rlallProfileId;
    private CircleImageView imageView;
    private String language;
    Context con;
    String login;
    ImageView closs_img; SettingsMain settingsMain;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        con = getApplicationContext();
        settingsMain = new SettingsMain(getApplicationContext());


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ivLogoHomeId = findViewById(R.id.ivLogoHomeId);

        ivnoticationHomeId = findViewById(R.id.ivnoticationHomeId);
        expandableListView = findViewById(R.id.expandableListView);
        tvhomeId = findViewById(R.id.tvhomeId);
        ivNofificationcoutId = findViewById(R.id.ivNofificationcoutId);


            prepareMenuData_Patient();
            populateExpandableList_Patient();
            replaceFragement_patient(new Patient_HomeFragment());


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        closs_img = navigationView.getHeaderView(0).findViewById(R.id.closs_img);
        ivLogoHomeId.setOnClickListener(this);
        ivnoticationHomeId.setOnClickListener(this);

        closs_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });

    }

    private void replaceFragement_patient(Patient_HomeFragment homeFragment) {
        FragmentTransaction home = getSupportFragmentManager().beginTransaction();
        home.replace(R.id.flHomeId, homeFragment);
        home.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivLogoHomeId:
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
                break;

            case R.id.ivnoticationHomeId:
                startActivity(new Intent(HomeActivity.this, Notification_Activity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }

//    ============= patient===============
private void prepareMenuData_Patient() {
    MenuModel menuModel = new MenuModel(getResources().getString(R.string.home), true, true, R.drawable.ic_arrow_back); //Menu of Android Tutorial. No sub menus
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.editprofile), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.myappointment), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.share), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.aboutus), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.help), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.language), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);

    menuModel = new MenuModel(getResources().getString(R.string.logout), true, true, R.drawable.ic_arrow_back); //Menu of Java Tutorials
    headerList.add(menuModel);
}

    private void populateExpandableList_Patient() {
        navigationExpandableListAdapter = new NavigationExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(navigationExpandableListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (headerList.get(groupPosition).isGroup) {
                    if (groupPosition == 0) {
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 1) {
                        startActivity(new Intent(HomeActivity.this, EditProfile_Activity.class));
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 2) {
                        startActivity(new Intent(HomeActivity.this, MyAppointment_Activity.class));
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 3) {
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 4) {
                        startActivity(new Intent(HomeActivity.this, Patient_Aboutus_Activity.class));
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 5) {
                        drawer.closeDrawer(Gravity.LEFT);
                        startActivity(new Intent(HomeActivity.this, Patient_Help_Activity.class));
                    } else if (groupPosition == 6) {
                        language_change();
                        drawer.closeDrawer(Gravity.LEFT);
                    } else if (groupPosition == 7) {
                        log_out();
                        drawer.closeDrawer(Gravity.LEFT);
                    }
                }
                return false;
            }
        });


    }

//=========================
    public void log_out() {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_log_out);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        ImageView ivlogoutClose = dialog.findViewById(R.id.ivlogoutCloseId);
        AppCompatImageView rllogout = dialog.findViewById(R.id.ivlogoutCloseId);
        Button btn_logout = dialog.findViewById(R.id.btn_logout);

        ivlogoutClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Patient_Login_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finishAffinity();
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


    public void language_change() {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_change_language);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        ImageView ivlogoutClose = dialog.findViewById(R.id.ivlogoutCloseId);
        ivlogoutClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
