package com.alpha.mainmenu.food_pkg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.cart_pkg.CartActivity;
import com.alpha.mainmenu.home_pkg.HomeFragment;
import com.alpha.mainmenu.product_details.ProductActivity;
import com.alpha.mainmenu.table_pkg.TableFragment;
import com.alpha.mainmenu.user_account_pkg.AccountFragment;
import com.alpha.mainmenu.utility.Constant;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvSelectorADoctor;
    AppCompatImageView ivLogoHomeId, ivserachHomeId, ivnoticationHomeId;
    DrawerLayout drawer;
    private AppCompatTextView tvUserName, tvEmail, ivNofificationcoutId, tvhomeId;
    private String Type_id, username, useremail, userimage, patient_id;
    private RelativeLayout rlallProfileId;
    private String language;
    Context con;
    String login;
    ImageView closs_img;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    Constant constant;
    LinearLayout ll_food,ll_home,ll_table,ll_acc,rlHomeToolbarId;
    ImageView iv_food,iv_home,iv_table,iv_acc;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        con = getApplicationContext();
        constant = new Constant(getApplicationContext());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        replaceFragement(new FoodFragment());
        ll_food = findViewById(R.id.ll_food);
        ll_home = findViewById(R.id.ll_home);
        ll_table = findViewById(R.id.ll_table);
        ll_acc = findViewById(R.id.ll_acc);
        iv_food = findViewById(R.id.iv_food);
        iv_home = findViewById(R.id.iv_home);
        iv_table = findViewById(R.id.iv_table);
        rlHomeToolbarId = findViewById(R.id.rlHomeToolbarId);
        iv_acc =findViewById(R.id.iv_acc);
        ll_food.setOnClickListener(this);
        ll_home.setOnClickListener(this);
        ll_table.setOnClickListener(this);
        ll_acc.setOnClickListener(this);
    }
    private void replaceFragement(FoodFragment homeFragment) {
        FragmentTransaction home = getSupportFragmentManager().beginTransaction();
        home.replace(R.id.flHomeId, homeFragment);
        home.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                iv_home.setImageResource(R.drawable.ic_home_active);
                iv_food.setImageResource(R.drawable.ic_food_notactive);
                iv_table.setImageResource(R.drawable.ic_table_notactive);
                iv_acc.setImageResource(R.drawable.ic_user_notactive);
                rlHomeToolbarId.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flHomeId, new HomeFragment())
                        .commit();
                break;
            case R.id.ll_food:
                iv_home.setImageResource(R.drawable.ic_home_notactive);
                iv_food.setImageResource(R.drawable.ic_food_active);
                iv_table.setImageResource(R.drawable.ic_table_notactive);
                iv_acc.setImageResource(R.drawable.ic_user_notactive);
                rlHomeToolbarId.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flHomeId, new FoodFragment())
                        .commit();
                break;
            case R.id.ll_table:
                iv_home.setImageResource(R.drawable.ic_home_notactive);
                iv_food.setImageResource(R.drawable.ic_food_notactive);
                iv_table.setImageResource(R.drawable.ic_table_active);
                iv_acc.setImageResource(R.drawable.ic_user_notactive);
                rlHomeToolbarId.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flHomeId, new TableFragment())
                        .commit();
                break;
            case R.id.ll_acc:
                iv_home.setImageResource(R.drawable.ic_home_notactive);
                iv_food.setImageResource(R.drawable.ic_food_notactive);
                iv_table.setImageResource(R.drawable.ic_table_notactive);
                iv_acc.setImageResource(R.drawable.ic_user_active);
                rlHomeToolbarId.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flHomeId, new AccountFragment())
                        .commit();
                break;
            case R.id.rlHomeToolbarId:
                startActivity(new Intent(FoodActivity.this, CartActivity.class));
                break;
        }
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
