package com.nr.mercadolibre.Interface.Api;

import com.nr.mercadolibre.Model.Entities.Category;
import com.nr.mercadolibre.Model.Entities.Country;
import com.nr.mercadolibre.Model.Entities.ListaProduct;
import com.nr.mercadolibre.rest.EndPoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET(EndPoints.GET_PRODUCT)
    Call<ListaProduct> obtenerListaProductos(@Query("q") String q);

    @GET(EndPoints.GET_SITES)
    Call<List<Country>> getCountry();

    @GET(EndPoints.GET_CATEGORYCOUNTRY)
    Call<List<Category>> getCategory(@Path("id") String id);
}
