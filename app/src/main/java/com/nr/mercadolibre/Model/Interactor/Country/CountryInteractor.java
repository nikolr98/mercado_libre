package com.nr.mercadolibre.Model.Interactor.Country;


import android.util.Log;

import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.rest.ApiAdapter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryInteractor implements CountryInterface.InterfaceModel {

    private CountryInterface.InterfacePresenter presenter;

    public CountryInteractor(CountryInterface.InterfacePresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void querySearch() {

        Call<List<Country>> listaproductos = ApiAdapter.getApiService().getCountry();
        listaproductos.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.isSuccessful()) {
                    List<Country> listCountry=response.body();
                    if (listCountry != null) {
                        successfulQuery(listCountry);
                    } else {
                        Log.e("onResponseCountry", "Response is null");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("onFailureCountry", "onFailure falla el consumo"+t.toString());

            }

         });
    }

    @Override
    public void successfulQuery(List<Country> countries) {
        presenter.onSuccessResult(countries);

    }

}
