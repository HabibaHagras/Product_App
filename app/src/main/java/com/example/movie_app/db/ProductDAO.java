package com.example.movie_app.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movie_app.Model.Product;

import java.nio.channels.SelectableChannel;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ProductDAO {
    @Query("SELECT * From product_table")
    Flowable<List<Product>> getAllProduct();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(Product product);
    @Delete
    Completable delete (Product product);
}
