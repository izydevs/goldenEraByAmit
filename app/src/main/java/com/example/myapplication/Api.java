package com.example.myapplication;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "https://gergstore.com/";

    @Headers("Content-Type: application/json")
    @POST("category_list.php")
    Call<Product> getProducts(@Body HashMap<String, String> user);
}