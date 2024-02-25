package com.example.movie_app.allProduct.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.movie_app.Model.Product;
import com.example.movie_app.Model.productRepositoryIm;
import com.example.movie_app.R;
import com.example.movie_app.allProduct.Presenter.AllProductPresenter;
import com.example.movie_app.allProduct.Presenter.AllProductPresenterIm;
import com.example.movie_app.db.AppDataBase;
import com.example.movie_app.db.ProductDAO;
import com.example.movie_app.db.ProductLocalDataSourceIm;
import com.example.movie_app.network.NetworkCallback;
import com.example.movie_app.network.ProductRemoteDataSource;
import com.example.movie_app.network.ProductRemoteDataSourceIm;


import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements   PutInFavListener ,AllProductView {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
//    ProductClient productClient;
    RycAdapter productAdapter;
    AppDataBase dp;
    ProductDAO DAO;
    List<Product> productList;
    AllProductPresenter allProductPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        recyclerView = findViewById(R.id.rv_products);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
   //      productClient=ProductClient.getInstance();
//        productClient.makeNetwokCall(this);

         productAdapter = new RycAdapter(this, new ArrayList<>(),this);
        recyclerView.setAdapter(productAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);
         dp=AppDataBase.getInstance(this);
         DAO=dp.getproductDAO();
        Product p = new Product(12,"test",22,"test","test","test","test", 2.4);
         allProductPresenter= new AllProductPresenterIm(this, productRepositoryIm.getInstance(ProductRemoteDataSourceIm.getInstance(), ProductLocalDataSourceIm.getInstance(this)));
         allProductPresenter.getProduct();

        }






//    @Override
//    public void onSucessResult(List<Product> products) {
//       productAdapter.SetList(products);
//      //  DAO.getAllProduct();
//        productAdapter.notifyDataSetChanged();
//
//    }
//
//    @Override
//    public void onFailuer(String error_msg) {
//
//    }

    @Override
    public void oPutInFavClick(Product product) {
        Toast.makeText(AllProductsActivity.this,"added",Toast.LENGTH_SHORT).show();
//        new  Thread(){
//            @Override
//            public void run() {
//                DAO.insert(product);
//            }
//        }.start();
//        productAdapter .notifyDataSetChanged();
        addProduct(product);
    }

    @Override
    public void showdata(List<Product> products) {
        productAdapter.SetList(products);
        productAdapter.notifyDataSetChanged();


    }

    @Override
    public void showErrorMsg(String error) {
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);
        alertDialog.setMessage(error).setTitle("An Error Equre");
        AlertDialog dialog = alertDialog.create();
        dialog.show();

    }

    @Override
    public void addProduct(Product product) {
        allProductPresenter.addtoFav(product);
    }
}