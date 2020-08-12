package com.alpha.mainmenu.history_pkg;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.table_pkg.TableCategoryFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyHistory_Activity extends AppCompatActivity {
    RecyclerView rv_order;
    public ArrayList<HistoryData> oderList;
    AppCompatImageView iv_back;
    View id_toolbar;
    AppCompatTextView tv_title;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhistory);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_tittle);
        tv_title.setText("History");
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)  findViewById(R.id.fr_history_frame);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_history_frame, new MyHistory_Fragment())
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                       getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fr_history_frame, new MyHistory_Fragment())
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fr_history_frame, new MyTable_Book_Fragment())
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


}
