package com.example.movie_app.db;

import androidx.lifecycle.LiveData;

import com.example.movie_app.Model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface ProductLocalDataSource {
    Completable insertProduct(Product product);
    Completable  deleteProduct (Product product);
    Flowable<List<Product>> getAllStoredProduct();
}
