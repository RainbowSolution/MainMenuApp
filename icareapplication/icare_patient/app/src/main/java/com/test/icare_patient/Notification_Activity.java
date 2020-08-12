package com.test.icare_patient;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Notification_Activity extends AppCompatActivity  implements View.OnClickListener{
      ImageView iv_back; RecyclerView rv_city;
    ArrayList<DummyDataPojo> cityLists;
    View id_toolbar; TextView tv_title;
    RelativeLayout rl_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_rv);

        id_toolbar = findViewById(R.id.id_toolbar);
        iv_back = id_toolbar.findViewById(R.id.id_back);
        tv_title = id_toolbar.findViewById(R.id.tv_title);
        rl_notification = id_toolbar.findViewById(R.id.rl_notification);
        rv_city = findViewById(R.id.id_rv);

        rl_notification.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        tv_title.setText("Notification");

        cityLists = new ArrayList<>();

        rv_city.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        loadData();
    }

    private void loadData() {
        for(int i=0; i<5; i++){
            DummyDataPojo dummyDataPojo = new DummyDataPojo("1","Appointment Booked","https://drop.ndtv.com/albums/AUTO/porsche-taycan-turbo/6401200x900_1_640x480.jpg");
            cityLists.add(dummyDataPojo);
        }

        SearchAdapter  searchAdapter = new SearchAdapter(getApplicationContext(), cityLists);
        rv_city.setAdapter(searchAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_notification:
                startActivity(getIntent());
                finish();
                break;

            case R.id.id_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }

    public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
        public ArrayList<DummyDataPojo> searchList;
        Context context;
        private LayoutInflater mInflater;

        public SearchAdapter(Context activity, ArrayList<DummyDataPojo> List) {
            searchList = List;
            context = activity;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView item_qnty,id_username,item_price;
            ImageView id_userpic;

            public MyViewHolder(View view) {
                super(view);
                id_username = view.findViewById(R.id.id_username);
                id_userpic = view.findViewById(R.id.id_userpic);
            }
        }

        @Override
        public SearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
            return new SearchAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final DummyDataPojo detail = searchList.get(position);

            holder.id_username.setText(detail.getName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.id_userpic.setImageDrawable(getDrawable(R.drawable.notification));
            }
        }


        @Override
        public int getItemCount() {
            return searchList.size();
        }
    }

}
