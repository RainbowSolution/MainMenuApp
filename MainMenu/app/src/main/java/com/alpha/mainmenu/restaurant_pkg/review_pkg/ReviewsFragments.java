package com.alpha.mainmenu.restaurant_pkg.review_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.table_pkg.Table_Category_Adapter;

import java.util.ArrayList;

public class ReviewsFragments extends Fragment {
    View v;
    public ArrayList<HistoryData> catList;
    RecyclerView rv_reviews;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.reviews_fragment_rv, container, false);
        rv_reviews = v.findViewById(R.id.rv_reviews);
        catList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_reviews.setLayoutManager(linearLayoutManager);
        getWeekendList();
        return v;
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            catList.add(new HistoryData("Food"));
        }
        ReviewAdapter adapter = new ReviewAdapter(getActivity(), catList);
        rv_reviews.setAdapter(adapter);
    }
}
