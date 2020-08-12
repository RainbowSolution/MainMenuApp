package com.alpha.mainmenu.cart_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.restaurant_pkg.Activity_Restaurant_Details;
import com.alpha.mainmenu.table_pkg.Table_Category_Adapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatImageView iv_back;
    View id_toolbar;
    AppCompatTextView tv_title;
    RecyclerView cat_rv;
    public ArrayList<HistoryData> cartList;
    AppCompatButton btn_Pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_tittle);
        btn_Pay = findViewById(R.id.btn_Pay);
        btn_Pay.setOnClickListener(this);
        tv_title.setText("Cart");
        iv_back.setOnClickListener(this);
        cat_rv = findViewById(R.id.cat_rv);
        cartList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CartActivity.this, RecyclerView.VERTICAL, false);
        cat_rv.setLayoutManager(linearLayoutManager);
        getWeekendList();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_back:
                onBackPressed();
                break;
            case R.id.btn_Pay:
                startActivity(new Intent(CartActivity.this, OrderConformActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            cartList.add(new HistoryData("Food"));
        }
        CartAdapter adapter = new CartAdapter(CartActivity.this, cartList);
        cat_rv.setAdapter(adapter);
    }
}
