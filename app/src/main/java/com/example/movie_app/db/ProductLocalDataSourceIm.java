package com.example.movie_app.db;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.movie_app.Model.Product;
import com.example.movie_app.allProduct.view.AllProductsActivity;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductLocalDataSourceIm  implements   ProductLocalDataSource {
    private ProductDAO dao;
    Flowable<List<Product>> storedProducts;
    private static ProductLocalDataSourceIm localDataSourceIm=null;
    public ProductLocalDataSourceIm(Context context) {
        AppDataBase appDataBase=AppDataBase.getInstance(context.getApplicationContext());
        dao=appDataBase.getproductDAO();
        storedProducts=dao.getAllProduct();

    }
public  static ProductLocalDataSourceIm getInstance(Context context){
        if(localDataSourceIm==null){
            localDataSourceIm=new ProductLocalDataSourceIm(context);
        }
        return localDataSourceIm;
}
    @Override
    public Completable insertProduct(Product product) {

       // Toast.makeText(AllProductsActivity.this,"added",Toast.LENGTH_SHORT).show();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//            dao.insert(product);
//            }
//        }).start();
        return dao.insert(product);

    }

    @Override
    public Completable deleteProduct(Product product) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                dao.delete(product);
//            }
//        }).start();
        return dao.delete(product);


    }

    @Override
    public Flowable <List<Product>> getAllStoredProduct() {
        return storedProducts;
    }
}
