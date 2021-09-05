package com.nr.mercadolibre.Presenter.Country;

import android.content.Context;

import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Country.CountryInteractor;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Model.Product.ProductInteractor;
import com.nr.mercadolibre.View.Country.Paises;

import java.util.ArrayList;
import java.util.List;

public class CountryPresenter implements CountryInterface.InterfacePresenter {

    private CountryInterface.InterfaceModel countryInterator;
    private CountryInterface.InterfaceView view;

    public CountryPresenter(CountryInterface.InterfaceView view) {
        this.countryInterator = new CountryInteractor(this);
        this.view = view;
    }

    @Override
    public void onSuccessResult(List<Country> countries) {
        view.hideProgresBar();
        view.showApodDetails(countries);

    }

    @Override
    public void requestData() {
        view.showProgresBar();
        countryInterator.querySearch();

    }

}
