package com.test.icare_patient.doctor_detail_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.icare_patient.R;
import com.test.icare_patient.patient.Dialog_Book_AppointmentFragment;


public class Doctor_Detail_Appointment_Adapter extends RecyclerView.Adapter<Doctor_Detail_Appointment_Adapter.ViewHolder> {
    private Context context;
    private OnClick onClick;

    public Doctor_Detail_Appointment_Adapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.patient_appointment_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
        // return categoryList == null ? 0 : categoryList.size();
    }

    public interface OnClick {
        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout btn_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_book = itemView.findViewById(R.id.rl_book);
        }

        @Override
        public void onClick(View v) {
            onClick.onClick(v, getAdapterPosition());
        }
    }
}
