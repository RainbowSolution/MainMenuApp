package com.alpha.mainmenu.history_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;

import java.util.ArrayList;

public class MyHistory_Fragment extends Fragment {
    View v;
    RecyclerView rv_order;
    public ArrayList<HistoryData> oderList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.my_history_fragment_rv, container, false);
        rv_order = v.findViewById(R.id.rv_order);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_order.setLayoutManager(linearLayoutManager);
        oderList = new ArrayList<>();
        getOrderendList();
        return v;
    }
    public void getOrderendList(){
        for(int i=0; i<10; i++){
            oderList.add(new HistoryData("Food"));
        }
        MyHistory_Adapter adapter = new MyHistory_Adapter(getActivity(), oderList);
        rv_order.setAdapter(adapter);
    }
}
