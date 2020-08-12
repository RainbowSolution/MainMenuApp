package com.alpha.mainmenu.restaurant_pkg.book_pkg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alpha.mainmenu.R;

public class BookFragment extends Fragment {
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     v = inflater.inflate(R.layout.booking_fragment, container, false);
      return v;
    }
}
