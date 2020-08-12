package com.alpha.mainmenu.home_pkg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.restaurant_pkg.Activity_Restaurant_Details;

import java.util.ArrayList;

public class Home_Category_Adapter extends RecyclerView.Adapter<Home_Category_Adapter.MyViewHolder> {
        public ArrayList<HistoryData> searchList;
        Context context;
        private LayoutInflater mInflater;

        public Home_Category_Adapter(Context activity, ArrayList<HistoryData> List) {
            searchList = List;
            context = activity;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            AppCompatTextView tv_productname;
            public MyViewHolder(View view) {
                super(view);
              //  tv_productname = view.findViewById(R.id.tv_productname);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_cat_row, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final HistoryData detail = searchList.get(position);

//            holder.tv_productname.setText(detail.getOrdername());

           holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, Activity_Restaurant_Details.class));
                }
            });

        }

        @Override
        public int getItemCount() {
            return searchList.size();
        }
    }