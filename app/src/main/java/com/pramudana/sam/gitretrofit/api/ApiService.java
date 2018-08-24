package com.pramudana.sam.gitretrofit.api;

import com.pramudana.sam.gitretrofit.response.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sampramudana on 8/24/18.
 */

public interface ApiService {

    @GET("read_data.php")
    Call<ResponseData> response_read_data();
}
