package com.nr.mercadolibre.Presenter.Category;

import android.content.Context;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Model.Category.CategoryInteractor;
import com.nr.mercadolibre.Model.Country.CountryInteractor;
import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Model.Entities.Country;

import java.util.List;

public class CategoryPresenter implements CategoryInterface.InterfacePresenter {


    private CategoryInterface.InterfaceModel categoryInterator;
    private CategoryInterface.InterfaceView view;

    public CategoryPresenter(CategoryInterface.InterfaceView view) {
        this.categoryInterator = new CategoryInteractor(this);
        this.view = view;
    }
    @Override
    public void onSuccessResult(List<Category> categories) {
        view.hideProgresBar();
        view.showApodDetails(categories);

    }

    @Override
    public void requestData(String id) {
        view.showProgresBar();
        categoryInterator.querySearch( id);

    }

}
