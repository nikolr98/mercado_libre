package com.nr.mercadolibre.Presenter.Country;

import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Model.Interactor.Country.CountryInteractor;
import com.nr.mercadolibre.Model.Entities.Country;

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
