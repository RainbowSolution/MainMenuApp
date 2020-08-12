package com.test.icare_patient.appointment_pkg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.icare_patient.R;
import com.test.icare_patient.patient.Dialog_Cancel_AppointmentFragment;


public class CurrentBooking_Adapter extends RecyclerView.Adapter<CurrentBooking_Adapter.ViewHolder> {
    private Context context;
    private OnClick onClick;

    public CurrentBooking_Adapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cancel_booking_history_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ll_cancel_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = (FragmentActivity) (context);
                FragmentManager fm = activity.getSupportFragmentManager();
                Dialog_Cancel_AppointmentFragment alertDialog = new Dialog_Cancel_AppointmentFragment();
                alertDialog.show(fm, "fragment_alert");
            }
        });
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

        LinearLayout ll_cancel_appointment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_cancel_appointment = itemView.findViewById(R.id.ll_cancel_appointment);
        }


        @Override
        public void onClick(View v) {
            onClick.onClick(v, getAdapterPosition());
        }
    }
}
