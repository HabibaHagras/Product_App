package com.example.movie_app.network;

import com.example.movie_app.Model.Product;

import java.util.List;

public interface NetworkCallback {
    public void onSucessResult(List<Product> products);
    public void onFailuer(String error_msg);

}
