package com.alpha.mainmenu.history_pkg;

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

import java.util.ArrayList;

public class MyHistory_Adapter extends RecyclerView.Adapter<MyHistory_Adapter.MyViewHolder> {
    public ArrayList<HistoryData> searchList;
    Context context;
    private LayoutInflater mInflater;

    public MyHistory_Adapter(Context activity, ArrayList<HistoryData> List) {
        searchList = List;
        context = activity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tv_productname;
        public MyViewHolder(View view) {
            super(view);
           // tv_productname = view.findViewById(R.id.tv_productname);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final HistoryData detail = searchList.get(position);
//        holder.tv_productname.setText(detail.getOrdername());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, MyHistory_Details_Activity.class));
                }
            });

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }
}