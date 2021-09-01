package com.nr.mercadolibre.Interface.Api;

import com.nr.mercadolibre.Model.Entities.ListaProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/sites/MCO/search?q=")
    Call<ListaProduct> obtenerListaProductos(@Query("q") String q);
}
