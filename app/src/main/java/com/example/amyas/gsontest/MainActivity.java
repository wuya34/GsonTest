package com.example.amyas.gsontest;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getConnected(getObserver());
    }

    //直接获取数据
    private void getConnected() {
        RetrofitService.getInstance().getCollections(1, 10, getObserver());
    }

    //自定义 retrofit操作流 获取数据
    private void getConnected(Observer<NewsBean> observer) {
        RetrofitService.getInstance().getCollectionsObservable(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private Observer<NewsBean> getObserver() {
        return new Observer<NewsBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: just subscribed");
            }

            @Override
            public void onNext(NewsBean newsBean) {
                Log.e(TAG, "accept: looper is " + Looper.myLooper());
                for (CollectionBean bean : newsBean.getData()) {
                    Log.e(TAG, "accept: bean " + bean);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }
        };
    }
}
