package com.example.movie_app.Fav.view;

import com.example.movie_app.Model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface AllFavView {

    public void showData(List<Product> products);
    public void removeProduct(Product product);
    public void showErrorMsg(String error);

    public void deleteProduct(Product product);
}
