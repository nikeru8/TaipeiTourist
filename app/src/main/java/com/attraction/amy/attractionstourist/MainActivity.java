package com.attraction.amy.attractionstourist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.attraction.amy.attractionstourist.observer.ObserverTaipeiData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ObserverTaipeiData {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.showtext);

        LoadDataUtil.loadTaipeiAttractions(this);

    }

    @Override
    public void onCompleted(AttractionsModel model) {
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
    public void onFail(Throwable error) {

    }
}
