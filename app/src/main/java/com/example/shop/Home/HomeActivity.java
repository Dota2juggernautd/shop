package com.example.shop.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.shop.ApiService;
import com.example.shop.Product;
import com.example.shop.Products;
import com.example.shop.R;
import com.example.shop.Retrofits.ApiHost;
import com.example.shop.ProductAdapter;
import com.example.shop.UserProfileActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    final String TAG = "HomeActivity";
    ArrayList<Product> productsList = new ArrayList<>();
    Products products = new Products();
    ImageView profile_button,img;
    TextView name_pro,rating_pro,description_pro;
    SharedPreferences preferences;
    int a;
    RecyclerView recyclerView ;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        onClickBtn();
        getProducts();


    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_products);
        profile_button = findViewById(R.id.profile_button);
        name_pro = findViewById(R.id.name_pro);
        description_pro = findViewById(R.id.description_pro);
        rating_pro = findViewById(R.id.rating);
        preferences = getSharedPreferences("MySharedPref", 0);
    }
    private void setAdapter(){
        productAdapter = new ProductAdapter(this, productsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);


    }

    private void onClickBtn() {
        profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, UserProfileActivity.class);
            startActivity(intent);
        });
    }

    public void getProducts () {
        ApiService apiService = ApiHost.getRetrofitInstance().create(ApiService.class);
        Call<Products> getProducts = apiService.getProducts();
        Log.e("Url= ", getProducts.request().url().toString());
        getProducts.enqueue(new Callback<Products>() {
                                    @SuppressLint("SetTextI18n")
                                    @Override
                                    public void onResponse(Call<Products> call, Response<Products> response) {
                                        products = response.body();
                                        Log.e(TAG, "onResponse: "+ response.body().getTotal());
                                        setToView();

                                    }
                                    @Override
                                    public void onFailure(Call<Products> call, Throwable t) {
                                        Toast.makeText(HomeActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        Log.e(TAG, t.getMessage());
                                    }
                                }
        );
    }
    private void setToView(){
        productsList.addAll(products.getProducts());
        setAdapter();

    }
    private void setMainCardData(){
        name_pro.setText(productsList.get());


    }

}
