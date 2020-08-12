package com.test.icare_patient.patient;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;

import com.test.icare_patient.R;


public class Dialog_Book_AppointmentFragment extends DialogFragment {
    AppCompatImageView cancle;
    RelativeLayout id_bookforanother,id_bookforme;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_book_appointment, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        cancle = rootView.findViewById(R.id.ivlogoutCloseId);
        id_bookforanother = rootView.findViewById(R.id.id_bookforanother);
        id_bookforme = rootView.findViewById(R.id.id_bookforme);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        id_bookforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Patient_Book_Appointment_Activity.class));
                dismiss();
            }
        });

        id_bookforanother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Patient_Book_Appointment_Another_Activity.class));
                dismiss();
            }
        });

        return rootView;
    }
}