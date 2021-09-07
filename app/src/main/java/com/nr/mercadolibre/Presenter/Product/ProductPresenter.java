package com.nr.mercadolibre.Presenter.Product;

import android.content.Context;

import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Model.Interactor.Product.ProductInteractor;

import java.util.ArrayList;

public class ProductPresenter implements ProductInterface.InterfacePresenter {

    private ProductInterface.InterfaceModel productInterator;
    private ProductInterface.InterfaceView view;


    public ProductPresenter( ProductInterface.InterfaceView view,Context context) {
        this.productInterator = new ProductInteractor(this,context);
        this.view = view;
    }

    @Override
    public void onSuccessResult(ArrayList<Product> productos) {
        view.hideProgresBar();
        view.hideNetworkError();
        view.hideError();
        view.showApodDetails(productos);

    }

    @Override
    public void requestData(String q) {
        view.hideNetworkError();
        view.hideError();
        view.showProgresBar();
        productInterator.querySearch(q);
    }

    @Override
    public void onFailureResult() {
        view.hideNetworkError();
        view.hideProgresBar();
        view.showError();

    }

    @Override
    public void onFailureNetwork() {
        view.showNetworkError();
        view.hideError();
        view.hideProgresBar();
    }


}
