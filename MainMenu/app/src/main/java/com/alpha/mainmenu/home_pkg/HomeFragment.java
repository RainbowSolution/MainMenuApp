package com.alpha.mainmenu.home_pkg;

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


public class HomeFragment extends Fragment {
    View v;
    public ArrayList<HistoryData> catList;
    public ArrayList<HistoryData> bannerList;
    public ArrayList<HistoryData> premiumList;
    public ArrayList<HistoryData> bestOfferList;
    RecyclerView cat_rv,rv_banner,rv_premium,rv_best_food;
    private ViewPager vpHomeBanner;
    private TabLayout tlHomeBanner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.home_fragment_rv, container, false);
        cat_rv = v.findViewById(R.id.id_rv_category);
        rv_banner = v.findViewById(R.id.rv_banner);
        rv_premium = v.findViewById(R.id.id_rv_premium);
        rv_best_food =v.findViewById(R.id.id_rv_best_food);
        vpHomeBanner = v.findViewById(R.id.vpHomeBannerId);
        tlHomeBanner = v.findViewById(R.id.tlHomeBannerId);
        bannerList = new ArrayList<>();
        catList = new ArrayList<>();
        premiumList = new ArrayList<>();
        bestOfferList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        cat_rv.setLayoutManager(linearLayoutManager1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rv_banner.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv_premium.setLayoutManager(linearLayoutManager2);
        LinearLayoutManager linearLayoutManager3= new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv_best_food.setLayoutManager(linearLayoutManager3);
        getWeekendList();
        getBannerList();
        getPrimiumList();
        getBestFoodList();
        return v;
    }

    public void getBannerList(){
        for(int i=0; i<5; i++){
            bannerList.add(new HistoryData("Food"));
        }
        HomeBannerAdapter adapter = new HomeBannerAdapter(getActivity(), bannerList);
        rv_banner.setAdapter(adapter);
    }


    public void getWeekendList(){
        for(int i=0; i<4; i++){
            catList.add(new HistoryData("Food"));
        }
        Home_Category_Adapter adapter = new Home_Category_Adapter(getActivity(), catList);
        cat_rv.setAdapter(adapter);
    }
    public void getPrimiumList(){
        for(int i=0; i<2; i++){
            premiumList.add(new HistoryData("Food"));
        }
        Home_Premium_Offer_Adapter adapter = new Home_Premium_Offer_Adapter(getActivity(), premiumList);
        rv_premium.setAdapter(adapter);
    }
    public void getBestFoodList(){
        for(int i=0; i<4; i++){
            bestOfferList.add(new HistoryData("Food"));
        }
        Home_Best_Offer_Adapter adapter = new Home_Best_Offer_Adapter(getActivity(), bestOfferList);
        rv_best_food.setAdapter(adapter);
    }
}

