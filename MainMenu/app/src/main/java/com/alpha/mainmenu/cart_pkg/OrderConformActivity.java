package com.alpha.mainmenu.cart_pkg;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;

import java.util.ArrayList;

public class OrderConformActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatImageView iv_back;
    View id_toolbar;
    AppCompatTextView tv_title;
    RecyclerView cat_rv;
    public ArrayList<HistoryData> cartList;
    AppCompatButton btn_Pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_confirmation_activity);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        iv_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_back:
                onBackPressed();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
