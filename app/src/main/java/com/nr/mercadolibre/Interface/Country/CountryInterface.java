package com.nr.mercadolibre.Interface.Country;

import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Model.Entities.Product;

import java.util.ArrayList;
import java.util.List;

public interface CountryInterface {
    interface  InterfaceView{

        void requestData();

        void showProgresBar();

        void hideProgresBar();

        void showApodDetails(List<Country> countries);

        void showNetworkError();

        void reloadData();

        void showError();

        void hideNetworkError();

        void hideError ();

    }


    interface  InterfacePresenter{

        void onSuccessResult(List<Country> countries);

        void requestData();

        void onFailureResult();

        void onFailureNetwork();

    }

    interface  InterfaceModel{

        void querySearch();

        void successfulQuery(ArrayList<Country> countries);

        void onFailureResult();

    }
}
