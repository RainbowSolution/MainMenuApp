package com.alpha.mainmenu.table_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;

import java.util.ArrayList;

public class TableCategoryFragment extends Fragment {
    View v;
    public ArrayList<HistoryData> catList;
    RecyclerView cat_rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         v = inflater.inflate(R.layout.table_fragment_category_rv, container, false);
         cat_rv = v.findViewById(R.id.rv_category);
         catList = new ArrayList<>();
         GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
         cat_rv.setLayoutManager(gridLayoutManager);
         getWeekendList();
        return v;
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            catList.add(new HistoryData("Food"));
        }
        Table_Category_Adapter adapter = new Table_Category_Adapter(getActivity(), catList);
        cat_rv.setAdapter(adapter);
    }
}
