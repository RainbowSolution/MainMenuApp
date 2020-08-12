package com.test.icare_patient.appointment_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.test.icare_patient.R;
import com.test.icare_patient.patient.Dialog_Book_AppointmentFragment;

public class Cancel_Booking_History_Fragment extends Fragment implements CancelBooking_Adapter.OnClick {
    private RecyclerView rvCancelBooking;
    private LinearLayoutManager linearLayoutManager;
    private CancelBooking_Adapter cancelBooking_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cancel_booking_history, null);
        init(rootView);
        return rootView;

    }

    private void init(View view) {
        rvCancelBooking = view.findViewById(R.id.rvCancelBookingId);
        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvCancelBooking.setLayoutManager(linearLayoutManager);
        cancelBooking_adapter = new CancelBooking_Adapter(getActivity(), this);
        rvCancelBooking.setAdapter(cancelBooking_adapter);
    }


    @Override
    public void onClick(View view, int position) {

    }
}

