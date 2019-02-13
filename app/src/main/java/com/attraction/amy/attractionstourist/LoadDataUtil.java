package com.attraction.amy.attractionstourist;

import android.support.annotation.NonNull;
import android.util.Log;

import com.attraction.amy.attractionstourist.observer.ObserverTaipeiData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadDataUtil {

    public static void loadTaipeiAttractions(final ObserverTaipeiData observer) {

        CallAttractionData.apiService.getCall().enqueue(new Callback<AttractionsModel>() {
            @Override
            public void onResponse(Call<AttractionsModel> call, @NonNull Response<AttractionsModel> response) {
                if (!response.isSuccessful())
                    return;

                AttractionsModel model = response.body();
                observer.onCompleted(model);

            }

            @Override
            public void onFailure(Call<AttractionsModel> call, Throwable t) {
                observer.onFail(t);
            }
        });

    }


}
