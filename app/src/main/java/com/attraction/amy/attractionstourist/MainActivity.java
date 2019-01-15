package com.attraction.amy.attractionstourist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.showtext);

        CallAttractionData.apiService.getCall().enqueue(new Callback<AttractionsModel>() {
            @Override
            public void onResponse(Call<AttractionsModel> call, @NonNull Response<AttractionsModel> response) {
                if (!response.isSuccessful())
                    return;

                AttractionsModel model = response.body();
                Log.d("MainActivity", "main = " + model.getResult().getCount());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < model.getResult().getCount(); i++) {
                    sb.append("景點: - " + model.getResult().getResults().get(i).getAttractionTitle() + "\n");
                    sb.append("介紹: - " + model.getResult().getResults().get(i).getTourist() + "\n");
                    sb.append("-------------------------- \n");
                    text.setText(sb);
                }
            }

            @Override
            public void onFailure(Call<AttractionsModel> call, Throwable t) {

            }
        });

    }
}
