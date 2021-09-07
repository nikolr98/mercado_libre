package com.nr.mercadolibre.Presenter.Category;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Model.Interactor.Category.CategoryInteractor;
import com.nr.mercadolibre.Model.Entities.Category;

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
