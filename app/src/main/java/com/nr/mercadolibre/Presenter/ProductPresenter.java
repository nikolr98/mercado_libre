package com.nr.mercadolibre.Presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Model.ProductInteractor;

import java.util.ArrayList;

public class ProductPresenter implements ProductInterface.InterfacePresenter {

    private ProductInterface.InterfaceModel productInterator;
    private ProductInterface.InterfaceView view;
    private Context context;

    public ProductPresenter( ProductInterface.InterfaceView view,Context context) {
        this.productInterator = new ProductInteractor(this);
        this.view = view;
        this.context=context;
    }

    @Override
    public void onSuccessResult(ArrayList<Product> productos) {
        view.hideProgresBar();
        view.showApodDetails(productos);

    }

    @Override
    public void requestData(String q) {
        view.showProgresBar();
        if (isOutputInternet()){
            productInterator.querySearch(q);
        }
        else{
            view.hideProgresBar();
            view.showNetworkError();
        }
    }

    @Override
    public void onFailureResult() {
        view.showNetworkError();
        view.hideProgresBar();

    }
    private boolean isOutputInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

}
