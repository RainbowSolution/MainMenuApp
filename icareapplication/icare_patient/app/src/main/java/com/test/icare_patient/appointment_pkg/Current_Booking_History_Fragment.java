package com.test.icare_patient.appointment_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.icare_patient.R;


public class Current_Booking_History_Fragment extends Fragment implements CurrentBooking_Adapter.OnClick {
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView rvCurrentBooking;
    private CurrentBooking_Adapter currentBooking_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.current_booking_history, null);
        init(rootView);
        return rootView;
    }

    private void init(View view) {
        rvCurrentBooking = view.findViewById(R.id.rvCurrentBookingId);
        linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvCurrentBooking.setLayoutManager(linearLayoutManager);
        currentBooking_adapter = new CurrentBooking_Adapter(getActivity(), this);
        rvCurrentBooking.setAdapter(currentBooking_adapter);
    }

    @Override
    public void onClick(View view, int position) {

    }
}

