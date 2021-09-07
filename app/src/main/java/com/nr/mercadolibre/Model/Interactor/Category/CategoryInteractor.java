package com.nr.mercadolibre.Model.Interactor.Category;

import android.util.Log;

import com.nr.mercadolibre.Interface.Category.CategoryInterface;
import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.rest.ApiAdapter;

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
        try {
            Call<List<Category>> listaCategorias= ApiAdapter.getApiService().getCategory(id);
            listaCategorias.enqueue(new Callback<List<Category>>() {
                @Override
                public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                    if (response.isSuccessful()) {
                        List<Category> listCategory=response.body();
                        if (listCategory != null) {
                            successfulQuery(listCategory);

                        } else {
                            Log.e("CategoryInteractor", "Response is null");
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Category>> call, Throwable t) {
                    Log.e("CategoryInteractor", "onFailure  falla el consumo"+t.toString());
                }
            });
        }catch (Exception e){
            Log.e("CategoryInteractor", "Error consumo"+e.toString());
        }
    }

    @Override
    public void successfulQuery(List<Category> countries) {
        presenter.onSuccessResult(countries);
    }


}
