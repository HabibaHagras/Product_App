package com.example.movie_app.Model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.movie_app.db.AppDataBase;
import com.example.movie_app.db.ProductDAO;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class Repository {
    private Context context;
    private ProductDAO productDAO;
    private Flowable<List<Product>> storedProduct;
    private static Repository repo =null;
    AppDataBase dp;
    ProductDAO DAO;
    private Repository(Context context){
        this.context=context;
        dp= AppDataBase.getInstance(context.getApplicationContext());
        DAO=dp.getproductDAO();
        storedProduct=DAO.getAllProduct();
    }
public static Repository getInstance(Context context){
        if (repo==null){
            repo =new Repository(context);
        }
        return repo;
}
public  Flowable<List<Product>> getStoredProduct(){
        return storedProduct;
}
public  void delete(Product product){
        new Thread(new Runnable() {
            @Override
            public void run() {
                DAO.delete(product);
            }
        });

}

}
