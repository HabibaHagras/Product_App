package com.example.movie_app.network;

import com.example.movie_app.Model.ProductResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Observable<ProductResponse> getProducts();
}
