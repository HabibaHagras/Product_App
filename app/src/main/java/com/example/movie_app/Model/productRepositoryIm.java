package com.example.movie_app.Model;

import androidx.lifecycle.LiveData;

import com.example.movie_app.db.ProductLocalDataSource;
import com.example.movie_app.network.NetworkCallback;
import com.example.movie_app.network.ProductRemoteDataSource;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class productRepositoryIm implements productRepository {
    ProductRemoteDataSource remoteDataSource;


    ProductLocalDataSource localDataSource;
    private  static  productRepositoryIm repo =null;


    public productRepositoryIm(ProductRemoteDataSource remoteDataSource, ProductLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static productRepositoryIm getInstance(ProductRemoteDataSource productRemoteDataSource , ProductLocalDataSource productLocalDataSource){
        if (repo==null){
            repo=new productRepositoryIm(productRemoteDataSource,productLocalDataSource);
        }
        return  repo;
    }

    @Override
    public Flowable<List<Product>> getStoredProduct() {
        return localDataSource.getAllStoredProduct();
    }

    @Override
    public Completable insertProduct(Product product) {
        return localDataSource.insertProduct(product);

    }

    @Override
    public Completable deleteProduct(Product product) {
        return    localDataSource.deleteProduct(product);

    }

    @Override
    public Observable<List<Product>> getAllProduct(NetworkCallback networkCallback) {
      return  remoteDataSource.makeNetwokCall(networkCallback);
    }
}
