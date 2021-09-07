package com.nr.mercadolibre.Model.Interactor.ProductCategory;

import android.util.Log;

import com.nr.mercadolibre.Interface.ProductCategory.ProductCategoryInterface;
import com.nr.mercadolibre.Model.Entities.ListaProduct;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.rest.ApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductCategoryInteractor implements ProductCategoryInterface.InterfaceModel {
    private ProductCategoryInterface.InterfacePresenter presenter;
    public ProductCategoryInteractor(ProductCategoryInterface.InterfacePresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void querySearch(String id_pais,String id_categoria) {

        Call<ListaProduct> listaproductos = ApiAdapter.getApiService().getProductForCategory(id_pais,id_categoria);
        listaproductos.enqueue(new Callback<ListaProduct>() {
            @Override
            public void onResponse(Call<ListaProduct> call, Response<ListaProduct> response) {
                ListaProduct listadeproductos = response.body();
                ArrayList<Product> productos = listadeproductos.getResults();
                if(productos.size()>0) {
                    successfulQuery(productos);
                }else {
                    Log.e("onResponsePC", "Response is null");
                }
            }

            @Override
            public void onFailure(Call<ListaProduct> call, Throwable t) {
                Log.e("onFailureCountry", "onFailure  falla el consumo"+t.toString());
            }
        });

    }

    @Override
    public void successfulQuery(ArrayList<Product> productos) {
        presenter.onSuccessResult(productos);

    }

}
