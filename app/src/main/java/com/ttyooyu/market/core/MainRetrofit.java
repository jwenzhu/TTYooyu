package com.ttyooyu.market.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Administrator on 2016-08-25.
 */
public class MainRetrofit {

    final TTYooYu mService;

    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();

    MainRetrofit() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(10, TimeUnit.SECONDS);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(MainFactory.HOST)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        mService = restAdapter.create(TTYooYu.class);
    }

    public TTYooYu getService(){
        return mService;
    }
}
