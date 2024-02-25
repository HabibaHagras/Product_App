package com.example.movie_app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName="product_table")
public class Product {
    @PrimaryKey
    @NonNull
    int id;
    @ColumnInfo(name = "title")
    String title ;
    @ColumnInfo(name = "productPrice")
    @SerializedName("price")

    double productPrice ;
    @ColumnInfo(name = "productBrand")

     @SerializedName("brand")
    String productBrand ;
    @ColumnInfo(name = "productcategory")
    @SerializedName("category")

    String productcategory;
    @ColumnInfo(name = "productthumbnail")
    @SerializedName("thumbnail")

    String productthumbnail ;
    @ColumnInfo(name = "rating")

    Double rating;

    public Product(int id ,String title, double productPrice, String productBrand, String productcategory, String productthumbnail, String productimages , Double rating) {
        this.id = id ;
        this.title = title;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productcategory = productcategory;
        this.rating =rating;
        this.productthumbnail = productthumbnail;
        this.productimages = productimages;
    }

    String productimages ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getProductthumbnail() {
        return productthumbnail;
    }

    public void setProductthumbnail(String productthumbnail) {
        this.productthumbnail = productthumbnail;
    }

    public String getProductimages() {
        return productimages;
    }

    public void setProductimages(String productimages) {
        this.productimages = productimages;
    }
}
