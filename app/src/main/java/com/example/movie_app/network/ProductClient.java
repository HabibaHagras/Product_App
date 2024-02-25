//package com.example.movie_app.network;
//
//import android.content.Context;
//
//import com.example.movie_app.Model.Product;
//import com.example.movie_app.Model.ProductResponse;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.Scheduler;
//import io.reactivex.rxjava3.plugins.RxJavaPlugins;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ProductClient {
////    private final Context context;
//    private List<Product> allProduct;
//    public static  ProductClient client =null;
//
//    public ProductClient() {
//
//    }
//    public static ProductClient getInstance(){
//        if (client==null){
//            client = new ProductClient();
//
//        }
//        return client;
//    }
//
//    public void makeNetwokCall(NetworkCallback networkCallback) {
//
//        Gson gson = new GsonBuilder().setLenient().create();
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create(gson)
//                ).addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .build();
//        ProductService myService = retrofit.create(ProductService.class);
//        Observable<ProductResponse> observable = myService.getProducts();
////        call.enqueue(new Callback<ProductResponse>(){
////
////
////            @Override
////            public void onResponse(Call<ProductResponse> call, Response<ProductResponse>response) {
////                networkCallback.onSucessResult(response.body().getProducts());
////                }
////
////            @Override
////            public void onFailure(Call<ProductResponse> call, Throwable t) {
////                networkCallback.onFailuer(t.getMessage());
////
////            }
////        });
//        observable.subscribeOn(Schedulers.io())
//                .map(iteam->iteam.getProducts()).subscribe();
//    }
//}