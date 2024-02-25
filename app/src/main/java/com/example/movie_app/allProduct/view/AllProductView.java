package com.example.movie_app.allProduct.view;

import com.example.movie_app.Model.Product;

import java.util.List;

public interface AllProductView {
    public void showdata(List<Product>products);
    public void showErrorMsg(String error);
    public void addProduct(Product product);
}
