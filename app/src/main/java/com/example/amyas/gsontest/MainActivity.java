package com.example.amyas.gsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getConnected();
    }

    private void getConnected(){
        Log.e(TAG, "getConnected: connecting");
//        GsonBuilder builder = new GsonBuilder();
//        builder.registerTypeAdapter(Date.class, new GsonDeserializers.DateDeserializer());
//        Gson gson = builder.create();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        Api retrofit = new Retrofit.Builder()
                .baseUrl(BasicMessage.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Api.class);
        Call<NewsBean> call = retrofit.news(BasicMessage.TOKEN, 1, 10);
        call.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                Log.e(TAG, "onResponse: "+ response.body());
                List<CollectionBean> list = response.body().getData();
                for (CollectionBean collectionBean : list) {
                    Log.e(TAG, "onResponse: "+collectionBean);
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t );
            }
        });
    }
}
