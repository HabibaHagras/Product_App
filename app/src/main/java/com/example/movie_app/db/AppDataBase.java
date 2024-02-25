package com.example.movie_app.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.movie_app.Model.Product;
@Database(entities = {Product.class},version = 1, exportSchema = false)

public  abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance =null;
    public abstract  ProductDAO getproductDAO();

    public static  synchronized  AppDataBase getInstance(Context context) {
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"Productdb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
