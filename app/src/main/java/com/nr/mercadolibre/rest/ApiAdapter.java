package com.nr.mercadolibre.rest;


import com.nr.mercadolibre.Interface.Api.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private ApiAdapter() {
    }

    private static ApiService apiService;

    public static ApiService getApiService() {

        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(EndPoints.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
