package com.example.movie_app.allProduct.Presenter;

import com.example.movie_app.Model.Product;
import com.example.movie_app.Model.Repository;
import com.example.movie_app.Model.productRepository;
import com.example.movie_app.allProduct.view.AllProductView;
import com.example.movie_app.network.NetworkCallback;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;

public class AllProductPresenterIm implements AllProductPresenter , NetworkCallback {
    private AllProductView _view ;
    private productRepository _Repository;

    public AllProductPresenterIm(AllProductView _view, productRepository _Repository) {
        this._view = _view;
        this._Repository = _Repository;
    }

    @Override
    public void getProduct() {
        _Repository.getAllProduct(this).observeOn(AndroidSchedulers.mainThread()).subscribe( iteam -> _view.showdata(iteam));

    }

    @Override
    public void addtoFav(Product product) {
        _Repository.insertProduct(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        () -> _view.showErrorMsg("Add to favourite successfully"),
                        error -> _view.showErrorMsg(error.getMessage())
                );
    }
    @Override
    public void onSucessResult(List<Product> products) {
      ;

    }

    @Override
    public void onFailuer(String error_msg) {
        _view.showErrorMsg(error_msg);
    }
}
