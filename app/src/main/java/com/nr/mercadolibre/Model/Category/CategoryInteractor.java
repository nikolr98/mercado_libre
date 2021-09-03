package com.nr.mercadolibre.Model.Category;

import android.util.Log;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Interface.Country.CountryInterface;
import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Presenter.Category.CategoryPresenter;
import com.nr.mercadolibre.rest.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryInteractor implements CategoryInterface.InterfaceModel {

    private CategoryInterface.InterfacePresenter presenter;

    public CategoryInteractor(CategoryInterface.InterfacePresenter presenter) {
        this.presenter = presenter;

    }
    @Override
    public void querySearch(String id) {
        Call<List<Category>> listaCategorias= ApiAdapter.getApiService().getCategory(id);
        listaCategorias.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    List<Category> listCategory=response.body();
                    if (listCategory != null) {
                        presenter.onSuccessResult(listCategory);
                    } else {
                        Log.e("onResponseUsers", "Response is null");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

    }

    @Override
    public void successfulQuery(ArrayList<Country> countries) {

    }

}
