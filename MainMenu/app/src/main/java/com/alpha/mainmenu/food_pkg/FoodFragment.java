package com.alpha.mainmenu.food_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class FoodFragment extends Fragment {
    View v;
    public ArrayList<HistoryData> catList;
    public ArrayList<HistoryData> bannerList;
    RecyclerView cat_rv,rv_banner;
    private ViewPager vpHomeBanner;
    private TabLayout tlHomeBanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.food_fragment_rv, container, false);
        cat_rv = v.findViewById(R.id.id_rv_category);
        rv_banner = v.findViewById(R.id.rv_banner);
        vpHomeBanner = v.findViewById(R.id.vpHomeBannerId);
        tlHomeBanner = v.findViewById(R.id.tlHomeBannerId);
        bannerList = new ArrayList<>();
        catList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        cat_rv.setLayoutManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rv_banner.setLayoutManager(linearLayoutManager);
        getWeekendList();
        getBannerList();
        return v;
    }


    public void getBannerList(){
        for(int i=0; i<5; i++){
            bannerList.add(new HistoryData("Food"));
        }
        BannerAdapter adapter = new BannerAdapter(getActivity(), bannerList);
        rv_banner.setAdapter(adapter);
    }


    public void getWeekendList(){
        for(int i=0; i<10; i++){
            catList.add(new HistoryData("Food"));
        }
        Food_Category_Adapter adapter = new Food_Category_Adapter(getActivity(), catList);
        cat_rv.setAdapter(adapter);
    }

}

