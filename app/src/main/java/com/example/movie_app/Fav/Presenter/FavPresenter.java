package com.example.movie_app.Fav.Presenter;

import com.example.movie_app.Model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface FavPresenter {
    public void deleteproduct(Product product);
    public Flowable<List<Product>> getStoredProducts();
    public void getFavProducts();

}
