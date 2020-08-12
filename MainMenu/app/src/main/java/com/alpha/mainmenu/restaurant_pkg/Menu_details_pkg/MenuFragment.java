package com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg.MenuFoodFragment;
import com.alpha.mainmenu.table_pkg.TableCategoryFragment;
import com.google.android.material.tabs.TabLayout;

public class MenuFragment extends Fragment {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.menu_fragment_rv, container, false);
        tabLayout=(TabLayout) v.findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)  v.findViewById(R.id.frame_menu);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_menu, new MenuFoodFragment())
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_menu, new MenuFoodFragment())
                                .commit();
                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_menu, new MenuFoodFragment())
                                .commit();
                        break;
                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_menu, new MenuFoodFragment())
                                .commit();
                        break;
                    case 3:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_menu, new MenuFoodFragment())
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
