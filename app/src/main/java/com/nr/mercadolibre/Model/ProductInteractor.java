package com.nr.mercadolibre.Model;

import com.nr.mercadolibre.Interface.Api.ApiService;
import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.ListaProduct;
import com.nr.mercadolibre.Model.Entities.Product;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductInteractor implements ProductInterface.InterfaceModel {

    private ProductInterface.InterfacePresenter presenter;

    public ProductInteractor(ProductInterface.InterfacePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void querySearch(String q) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService servicio = retrofit.create(ApiService.class);
        Call<ListaProduct> listaproductos = servicio.obtenerListaProductos(q);
        listaproductos.enqueue(new Callback<ListaProduct>() {
            @Override
            public void onResponse(Call<ListaProduct> call, Response<ListaProduct> response) {
                if(!response.isSuccessful()) {
                    onFailureResult();
                }
                ListaProduct listadeproductos = response.body();
                ArrayList<Product> productos = listadeproductos.getResults();
                if(productos.size()>0) {
                    successfulQuery(productos);
                }else{
                    onFailureResult();
                }
            }

            @Override
            public void onFailure(Call<ListaProduct> call, Throwable t) {
                onFailureResult();
            }
        });

    }

    @Override
    public void successfulQuery(ArrayList<Product> productos) {
        presenter.onSuccessResult(productos);

    }

    @Override
    public void onFailureResult() {

    }
}
