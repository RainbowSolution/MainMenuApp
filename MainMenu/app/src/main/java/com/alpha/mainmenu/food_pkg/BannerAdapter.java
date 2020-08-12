package com.alpha.mainmenu.food_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;

        public BannerAdapter(Context activity, ArrayList<HistoryData> List) {
            searchList = List;
            context = activity;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView ivSlideId;

            public MyViewHolder(View view) {
                super(view);
                ivSlideId = view.findViewById(R.id.ivSlideId);
            }
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final HistoryData detail = searchList.get(position);
            Glide.with(context)
                    .load(R.drawable.ic_banner_background)
                    .into(holder.ivSlideId);
        }

        @Override
        public int getItemCount() {
            return searchList.size();
        }
    }