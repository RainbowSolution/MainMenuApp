package com.test.icare_patient.patient_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.icare_patient.R;
import com.test.icare_patient.doctor_detail_pkg.DoctorDetailActivity;


public class Doctor_List_Adapter extends RecyclerView.Adapter<Doctor_List_Adapter.ViewHolder> {
    private Context context;
    private OnClick onClick;

    public Doctor_List_Adapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.patient_home_doctor_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DoctorDetailActivity.class));
            }
        });
    }


 /*   public void addCategoryList(List<Datum> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }*/

    @Override
    public int getItemCount() {
        return 5;
        // return categoryList == null ? 0 : categoryList.size();
    }

    public interface OnClick {
        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button btn_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_book = itemView.findViewById(R.id.btn_book);
        }

        @Override
        public void onClick(View v) {
            onClick.onClick(v, getAdapterPosition());
        }
    }
}
