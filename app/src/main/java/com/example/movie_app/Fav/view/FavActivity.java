package com.example.movie_app.Fav.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movie_app.Fav.Presenter.FavPresenter;
import com.example.movie_app.Fav.Presenter.FavPresenterIm;
import com.example.movie_app.Model.Product;
import com.example.movie_app.Model.Repository;
import com.example.movie_app.Model.productRepositoryIm;
import com.example.movie_app.R;
import com.example.movie_app.db.AppDataBase;
import com.example.movie_app.db.ProductDAO;
import com.example.movie_app.db.ProductLocalDataSourceIm;
import com.example.movie_app.network.ProductRemoteDataSourceIm;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;


public class FavActivity extends AppCompatActivity implements OnClickFavListener , AllFavView {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    public FavAdpter favproductAdapter;
    AppDataBase dp;
    ProductDAO DAO;
    Repository repo ;
    FavPresenter favPresenter;
    List<Product> productsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        recyclerView = findViewById(R.id.fav_products);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        favproductAdapter = new FavAdpter(this, new ArrayList<>(),this);
        recyclerView.setAdapter(favproductAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
         dp=AppDataBase.getInstance(this);
         DAO=dp.getproductDAO();
         repo=Repository.getInstance(this);
       // favproductAdapter.SetList( repo.getStoredProduct());
        favproductAdapter.notifyDataSetChanged();
        favPresenter=new FavPresenterIm(this, productRepositoryIm.getInstance(ProductRemoteDataSourceIm.getInstance(), ProductLocalDataSourceIm.getInstance(this)));

      //  productsList = favPresenter.getStoredProducts();
        favPresenter.getFavProducts();

      //  showData(productsList);

    }

    @Override
    public void onFavProductClick(Product product) {
        Toast.makeText(FavActivity.this,"DELETED",Toast.LENGTH_SHORT).show();
//        new  Thread(){
//            @Override
//            public void run() {
//                DAO.delete(product);
//            }
//        }.start();
//        favproductAdapter.notifyDataSetChanged();
        deleteProduct(product);
    }



    @Override
    public void showData(List<Product> products) {

                  //  favproductAdapter.SetList(products);
        favproductAdapter = new FavAdpter(this,products,this);
        recyclerView.setAdapter(favproductAdapter);

    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public void showErrorMsg(String error) {

    }

    @Override
    public void deleteProduct(Product product) {
        favPresenter.deleteproduct(product);

    }
}