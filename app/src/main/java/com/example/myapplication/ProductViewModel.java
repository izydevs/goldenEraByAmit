package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<Product> productList;
    private MutableLiveData<String> responseStatus = new MutableLiveData<String>();
    ;

    //we will call this method to get the data
    public LiveData<Product> getProductlist() {
        //if the list is null
        if (productList == null) {
            productList = new MutableLiveData<Product>();
            //we will load it asynchronously from server in this method
            Log.d("asdf", "getproduct list");
            loadProduct();

        }

        //finally we will return the list
        return productList;
    }

    //This method is using Retrofit to get the JSON data from URL
    private void loadProduct() {


        HashMap<String, String> user = new HashMap<>();
        user.put("id_category", "43");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<Product> call = api.getProducts(user);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

                //finally we are setting the list to our MutableLiveData
                Log.d("asdf", "response is " + response.body().toString());
                productList.setValue(response.body());
                //responseStatus.setValue("hide");
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                //responseStatus.setValue("hide");
            }
        });

        Gson gson = new Gson();
        Product obj = gson.fromJson(Utils.data, Product.class);
        productList.setValue(obj);

    }

}
