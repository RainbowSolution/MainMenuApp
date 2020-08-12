package com.alpha.mainmenu.restaurant_pkg.gallery_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.table_pkg.Table_Category_Adapter;

import java.util.ArrayList;

public class Gallery_Fragment extends Fragment {
    View v;
    public ArrayList<HistoryData> catList;
    RecyclerView rv_gallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.gallery_fragment_rv, container, false);
        rv_gallery = v.findViewById(R.id.rv_gallery);
        catList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rv_gallery.setLayoutManager(gridLayoutManager);
        getWeekendList();
        return v;
    }

    public void getWeekendList() {
        for (int i = 0; i < 6; i++) {
            catList.add(new HistoryData("Food"));
        }
        Gallery_Adapter adapter = new Gallery_Adapter(getActivity(), catList);
        rv_gallery.setAdapter(adapter);
    }
}