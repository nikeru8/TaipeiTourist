package com.attraction.amy.attractionstourist;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface CallAttractionData {
    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=36847f3f-deff-4183-a5bb-800737591de5")
    Call<AttractionsModel> getCall();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://data.taipei/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    CallAttractionData apiService = retrofit.create(CallAttractionData.class);

}