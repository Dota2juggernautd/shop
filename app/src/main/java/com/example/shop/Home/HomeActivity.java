package com.example.shop.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.shop.R;
import com.example.shop.State;
import com.example.shop.StateAdapter;
import com.example.shop.UserProfileActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    ImageView profile_button;
    String get_shared_img;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        getData();

        clickBtn();
        setInitialData();

    }
    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.list);
        StateAdapter adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);
        profile_button = findViewById(R.id.profile_button);
        preferences = getSharedPreferences("MySharedPref",0);
    }
    private void clickBtn(){
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

    }
    private void setInitialData(){
        states.add(new State ("Smart Apple Watch SE", "Jode Electronics", R.drawable.whatch , (float) 169.54));
        states.add(new State ("HP Laptop - 10th generation", "Maddy Workspaces", R.drawable.laptop,(float) 499.99));
        states.add(new State ("Logitech G433 Headset", "Zone Electrons", R.drawable.headset ,(float) 69.69));
        states.add(new State ("Wooden Monitor Stand", "Walnus Home", R.drawable.monitor_stand ,(float) 169.54));
        states.add(new State ("Чили", "Сантьяго", R.drawable.laptop ,(float) 169.54));
    }
    private void getData(){
        get_shared_img = preferences.getString("img","-1");


    }
}
