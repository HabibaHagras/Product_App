package com.example.movie_app.Fav.Presenter;

import com.example.movie_app.Fav.view.AllFavView;
import com.example.movie_app.Model.Product;
import com.example.movie_app.Model.productRepository;
import com.example.movie_app.Model.productRepositoryIm;
import com.example.movie_app.allProduct.view.AllProductView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavPresenterIm implements FavPresenter{
    private AllFavView _view ;
    private productRepositoryIm _Repository;

    public FavPresenterIm(AllFavView _view, productRepositoryIm _Repository) {
        this._view = _view;
        this._Repository = _Repository;
    }
    @Override
    public void getFavProducts() {
        _Repository.getStoredProduct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(products -> {
                    _view.showData(products);
                });
    }
  //  @Override
//    public Observable<List<Product>> getProduct() {
//       return  _Repository.getStoredProduct().flatMapIterable(iteam->iteam);
//
//    }
//    public  void  getStoredProducts() {
//         _Repository.getStoredProduct()     .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(products -> {
//                    _view.showdata(products);
//                });;
//    }



    @Override
    public void deleteproduct(Product product) {
        _Repository.deleteProduct(product);
    }

    @Override
    public Flowable<List<Product>> getStoredProducts() {
        return _Repository.getStoredProduct();
    }

}


