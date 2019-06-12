package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ProductViewModel model;
    HashMap<String ,List<Product.Categorys>> productList= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model = ViewModelProviders.of(this).get(ProductViewModel.class);

        model.getProductlist().observe(this, new Observer<Product>() {
            @Override
            public void onChanged(@Nullable Product product) {
                productList.put("Women",product.getWomen());
                productList.put("Men",product.getMen());
                productList.put("Kids",product.getKids());
                productAdapter = new ProductAdapter(MainActivity.this, productList);
                recyclerView.setAdapter(productAdapter);
                Log.d("asdf","name is "+product.getKids().get(0).name);

            }
        });
    }
}
