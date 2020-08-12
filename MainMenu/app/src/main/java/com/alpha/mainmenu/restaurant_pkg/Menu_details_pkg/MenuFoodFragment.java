package com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.alpha.mainmenu.restaurant_pkg.Menu_details_pkg.GenreDataFactory.makeGenres;

public class MenuFoodFragment extends Fragment {

    private MultiTypeGenreAdapter adapter;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.menu_food_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new MultiTypeGenreAdapter(makeGenres());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }


    public static class ExpandableListDataPump {
        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

            List<String> student1 = new ArrayList<String>();
            student1.add("test");
            student1.add("test1");
            student1.add("test2");
            student1.add("test3");
            student1.add("test4");
            student1.add("test");

            List<String> student2 = new ArrayList<String>();
            student2.add("Brazil");
            student2.add("Spain");
            student2.add("Germany");
            student2.add("Netherlands");
            student2.add("Italy");

            List<String> student3 = new ArrayList<String>();
            student3.add("United States");
            student3.add("Spain");
            student3.add("Argentina");
            student3.add("France");
            student3.add("Russia");

            expandableListDetail.put("111", student1);
            expandableListDetail.put("222", student2);
            expandableListDetail.put("333", student3);
            return expandableListDetail;
        }


    }
}