package com.nr.mercadolibre.Model.Product;

import android.content.Context;
import com.nr.mercadolibre.Interface.Product.ProductInterface;
import com.nr.mercadolibre.Model.Entities.ListaProduct;
import com.nr.mercadolibre.Model.Entities.Product;
import com.nr.mercadolibre.Utils.ConexionInternet;
import com.nr.mercadolibre.rest.ApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductInteractor implements ProductInterface.InterfaceModel {

    private ProductInterface.InterfacePresenter presenter;
    private Context context;
    public ProductInteractor(ProductInterface.InterfacePresenter presenter,Context context) {
        this.presenter = presenter;
        this.context=context;

    }

    @Override
    public void querySearch(String q) {
        if (!ConexionInternet.isOutputInternet(context)){
            onFailureNetwork();
          return;
        }

        Call<ListaProduct> listaproductos = ApiAdapter.getApiService().obtenerListaProductos(q);
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
        presenter.onFailureResult();
    }

    @Override
    public void onFailureNetwork() {
        presenter.onFailureNetwork();

    }

}
