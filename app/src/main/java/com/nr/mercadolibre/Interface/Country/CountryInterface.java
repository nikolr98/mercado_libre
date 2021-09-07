package com.nr.mercadolibre.Interface.Country;

import com.nr.mercadolibre.Model.Entities.Country;

import java.util.List;

public interface CountryInterface {
    interface  InterfaceView{

        void requestData();

        void showProgresBar();

        void hideProgresBar();

        void showApodDetails(List<Country> countries);

    }


    interface  InterfacePresenter{

        void onSuccessResult(List<Country> countries);

        void requestData();

    }

    interface  InterfaceModel{

        void querySearch();

        void successfulQuery(List<Country> countries);

    }
}
