package com.nr.mercadolibre.Model.Country;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.nr.mercadolibre.Interface.Api.ApiService;
import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Model.Entities.ListaProduct;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.rest.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                        presenter.onSuccessResult(listCountry);
                    } else {
                        Log.e("onResponseUsers", "Response is null");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }

         });
    }

    @Override
    public void successfulQuery(ArrayList<Country> countries) {

    }

    @Override
    public void onFailureResult() {

    }
}
