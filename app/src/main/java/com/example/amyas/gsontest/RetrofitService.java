package com.example.amyas.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: Amyas
 * date: 2017/12/6
 */

public class RetrofitService {
    private Api mApi;
    private RetrofitService(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        mApi = new Retrofit.Builder()
                .baseUrl(BasicMessage.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class);
    }
    private static class singleInstance{
        public static final RetrofitService instance = new RetrofitService();
    }
    public static RetrofitService getInstance(){
        return singleInstance.instance;
    }

    public void getCollections(int page, int limit, Observer<NewsBean> observer){
        mApi.news(BasicMessage.TOKEN, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public Observable<NewsBean> getCollectionsObservable(int page, int limit){
        return mApi.news(BasicMessage.TOKEN, page, limit);
    }
}
