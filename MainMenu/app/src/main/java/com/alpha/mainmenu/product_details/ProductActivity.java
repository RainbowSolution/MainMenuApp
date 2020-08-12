package com.alpha.mainmenu.product_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.model.HistoryData;
import com.alpha.mainmenu.restaurant_pkg.review_pkg.ReviewAdapter;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatImageView iv_back;
    View v;
    RecyclerView rv_product;
    public ArrayList<HistoryData> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        iv_back = findViewById(R.id.ivBackSearchId);
        iv_back.setOnClickListener(this);
        rv_product = findViewById(R.id.rv_product);
        productList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductActivity.this, RecyclerView.VERTICAL, false);
        rv_product.setLayoutManager(linearLayoutManager);
        getWeekendList();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBackSearchId:
               onBackPressed();
                break;
        }
    }
    public void getWeekendList(){
        for(int i=0; i<4; i++){
            productList.add(new HistoryData("Food"));
        }
        ProductAdapter adapter = new ProductAdapter(ProductActivity.this, productList);
        rv_product.setAdapter(adapter);
    }
}
