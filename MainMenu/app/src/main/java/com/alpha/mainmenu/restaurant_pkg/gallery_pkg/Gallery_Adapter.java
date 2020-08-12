package com.alpha.mainmenu.restaurant_pkg.gallery_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.restaurant_pkg.review_pkg.ReviewAdapter;

import java.util.ArrayList;

public class Gallery_Adapter extends RecyclerView.Adapter<Gallery_Adapter.MyViewHolder> {
    public ArrayList<HistoryData> searchList;
    Context context;
    private LayoutInflater mInflater;

    public Gallery_Adapter(Context activity, ArrayList<HistoryData> List) {
        searchList = List;
        context = activity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tv_productname;
        AppCompatButton btn_restaurant;
        public MyViewHolder(View view) {
            super(view);
            tv_productname = view.findViewById(R.id.tv_productname);
            btn_restaurant = view.findViewById(R.id.btn_restaurant);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final HistoryData detail = searchList.get(position);

//            holder.tv_productname.setText(detail.getOrdername());



    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }
}