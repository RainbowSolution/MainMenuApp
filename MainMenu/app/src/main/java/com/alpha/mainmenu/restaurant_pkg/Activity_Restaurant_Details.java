package com.alpha.mainmenu.restaurant_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.cart_pkg.CartActivity;
import com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg.MenuFragment;
import com.alpha.mainmenu.restaurant_pkg.book_pkg.BookFragment;
import com.alpha.mainmenu.restaurant_pkg.gallery_pkg.Gallery_Fragment;
import com.alpha.mainmenu.restaurant_pkg.overview_pkg.OverviewFragment;
import com.alpha.mainmenu.restaurant_pkg.review_pkg.ReviewsFragments;
import com.google.android.material.tabs.TabLayout;

public class Activity_Restaurant_Details extends AppCompatActivity implements View.OnClickListener {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LinearLayout li_view_item;
    AppCompatImageView ivBackForgetId;
    AppCompatButton btn_booking_table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)  findViewById(R.id.frame_details);
        li_view_item = findViewById(R.id.li_view_item);
        ivBackForgetId = findViewById(R.id.ivBackForgetId);
        btn_booking_table = findViewById(R.id.btn_booking_table);
        ivBackForgetId.setOnClickListener(this);
        btn_booking_table.setOnClickListener(this);
        li_view_item.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_details, new MenuFragment())
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        li_view_item.setVisibility(View.VISIBLE);
                       getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_details, new MenuFragment())
                                .commit();
                        break;
                    case 1:
                        li_view_item.setVisibility(View.GONE);
                       getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_details, new OverviewFragment())
                                .commit();
                        break;
                    case 2:
                        li_view_item.setVisibility(View.GONE);
                       getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_details, new Gallery_Fragment())
                                .commit();
                        break;
                    case 3:
                        li_view_item.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_details, new ReviewsFragments())
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.li_view_item:
                startActivity(new Intent(Activity_Restaurant_Details.this, CartActivity.class));
                break;
            case R.id.ivBackForgetId:
                onBackPressed();
                break;
            case R.id.btn_booking_table:
                li_view_item.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_details, new BookFragment())
                        .commit();
                break;
        }
    }
}
