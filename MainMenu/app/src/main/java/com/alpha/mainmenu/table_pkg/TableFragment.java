package com.alpha.mainmenu.table_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.food_pkg.FoodFragment;
import com.alpha.mainmenu.home_pkg.HomeBannerAdapter;
import com.alpha.mainmenu.home_pkg.HomeFragment;
import com.alpha.mainmenu.home_pkg.Home_Best_Offer_Adapter;
import com.alpha.mainmenu.home_pkg.Home_Category_Adapter;
import com.alpha.mainmenu.home_pkg.Home_Premium_Offer_Adapter;
import com.alpha.mainmenu.model.HistoryData;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class TableFragment extends Fragment {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.table_fragment_rv, container, false);
        /*cat_rv = v.findViewById(R.id.id_rv_category);
        catList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        cat_rv.setLayoutManager(gridLayoutManager);
        getWeekendList();*/
        tabLayout=(TabLayout) v.findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)  v.findViewById(R.id.frame_table);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_table, new TableCategoryFragment())
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_table, new TableCategoryFragment())
                                .commit();
                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_table, new TableCategoryFragment())
                                .commit();
                        break;
                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_table, new TableCategoryFragment())
                                .commit();
                        break;
                    case 3:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_table, new TableCategoryFragment())
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
                return v;
    }

}

