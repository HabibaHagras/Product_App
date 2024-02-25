package com.example.movie_app.network;

import com.example.movie_app.Model.Product;
import com.example.movie_app.Model.ProductResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductRemoteDataSourceIm implements ProductRemoteDataSource{
    private List<Product> allProduct;
    public static  ProductRemoteDataSourceIm client =null;
    ProductService myService;
    private ProductRemoteDataSourceIm() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
         myService = retrofit.create(ProductService.class);

    }
    public static ProductRemoteDataSourceIm getInstance(){
        if (client==null){
            client = new ProductRemoteDataSourceIm();

        }
        return client;
    }
@Override
    public Observable<List<Product>> makeNetwokCall(NetworkCallback networkCallback) {
        Observable<ProductResponse> observable = myService.getProducts();
//        call.enqueue(new Callback<ProductResponse>(){
//
//
//            @Override
//            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
//                networkCallback.onSucessResult(response.body().getProducts());
//            }
//
//            @Override
//            public void onFailure(Call<ProductResponse> call, Throwable t) {
//                networkCallback.onFailuer(t.getMessage());
//
//            }
//        });
   return  observable.subscribeOn(Schedulers.io())
            .map(iteam-> iteam.getProducts());
    }
}
