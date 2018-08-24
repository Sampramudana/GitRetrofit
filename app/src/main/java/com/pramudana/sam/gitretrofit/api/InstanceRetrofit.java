package com.pramudana.sam.gitretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sampramudana on 8/24/18.
 */

public class InstanceRetrofit {
    public static final String webUrl = "http://192.168.10.52./GitRetrofit/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(webUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
