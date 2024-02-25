package com.example.movie_app.Model;

import androidx.lifecycle.LiveData;

import com.example.movie_app.network.NetworkCallback;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface productRepository  {
    public Flowable<List<Product>> getStoredProduct();
    public Completable insertProduct(Product product);
    public  Completable  deleteProduct(Product product);
    public Observable<List<Product>> getAllProduct(NetworkCallback networkCallback);
}
