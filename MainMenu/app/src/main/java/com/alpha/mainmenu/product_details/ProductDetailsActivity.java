package com.alpha.mainmenu.product_details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.cart_pkg.CartActivity;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.restaurant_pkg.Activity_Restaurant_Details;
import com.alpha.mainmenu.restaurant_pkg.review_pkg.ReviewAdapter;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatImageView iv_back;
    View id_toolbar;
    AppCompatTextView tv_title;
    RecyclerView cat_rv;
    public ArrayList<HistoryData> cartList;
    AppCompatButton btn_Pay;
    public ArrayList<HistoryData> catList;
    RecyclerView rv_reviews;
    LinearLayout li_view_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_tittle);
        tv_title.setText("Details");
        iv_back.setOnClickListener(this);
        li_view_item = findViewById(R.id.li_view_item);
        li_view_item.setOnClickListener(this);
        rv_reviews = findViewById(R.id.rv_reviews);
        catList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductDetailsActivity.this, RecyclerView.VERTICAL, false);
        rv_reviews.setLayoutManager(linearLayoutManager);
        getWeekendList();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_back:
                onBackPressed();
                break;
            case R.id.li_view_item:
                startActivity(new Intent(ProductDetailsActivity.this, CartActivity.class));
                break;

        }
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            catList.add(new HistoryData("Food"));
        }
        ReviewAdapter adapter = new ReviewAdapter(ProductDetailsActivity.this, catList);
        rv_reviews.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
