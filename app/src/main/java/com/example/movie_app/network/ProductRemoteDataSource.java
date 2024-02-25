package com.example.movie_app.network;

import com.example.movie_app.Model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface ProductRemoteDataSource {
    Observable<List<Product>> makeNetwokCall(NetworkCallback networkCallback);
}
