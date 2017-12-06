package com.example.amyas.gsontest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * author: Amyas
 * date: 2017/12/6
 */

public interface Api {
    @GET("app/collection/list")
    Call<NewsBean> news(@Header("authorization") String authorization,
                            @Query("page") int page,
                            @Query("limit") int limit);
}
