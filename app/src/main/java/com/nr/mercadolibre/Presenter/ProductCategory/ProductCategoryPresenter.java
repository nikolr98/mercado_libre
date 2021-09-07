package com.nr.mercadolibre.Presenter.ProductCategory;

import android.content.Context;

import com.nr.mercadolibre.Interface.ProductCategory.ProductCategoryInterface;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Model.Interactor.ProductCategory.ProductCategoryInteractor;

import java.util.ArrayList;

public class ProductCategoryPresenter implements ProductCategoryInterface.InterfacePresenter {


    private ProductCategoryInterface.InterfaceModel productInterator;
    private ProductCategoryInterface.InterfaceView view;


    public ProductCategoryPresenter(ProductCategoryInterface.InterfaceView view, Context context) {
        this.productInterator = new ProductCategoryInteractor(this);
        this.view = view;
    }

    @Override
    public void onSuccessResult(ArrayList<Product> productos) {
        view.hideProgresBar();
        view.showApodDetails(productos);

    }

    @Override
    public void requestData(String id_pais,String id_categoria) {
        view.showProgresBar();
        productInterator.querySearch( id_pais, id_categoria);
    }


}
