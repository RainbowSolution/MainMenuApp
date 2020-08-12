package com.alpha.mainmenu.search_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.cart_pkg.CartActivity;
import com.alpha.mainmenu.cart_pkg.CartAdapter;
import com.alpha.mainmenu.cart_pkg.OrderConformActivity;
import com.alpha.mainmenu.model.HistoryData;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView cat_rv;
    public ArrayList<HistoryData> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        cat_rv = findViewById(R.id.cat_rv);
        cartList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this, RecyclerView.VERTICAL, false);
        cat_rv.setLayoutManager(linearLayoutManager);
        getWeekendList();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            cartList.add(new HistoryData("Food"));
        }
        SearchAdapter adapter = new SearchAdapter(SearchActivity.this, cartList);
        cat_rv.setAdapter(adapter);
    }
}
