package com.only1.dagger2.sample.simple;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by daehwang on 10/05/2017.
 */

interface MovieApi {

    @GET("boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e")
    Call<DailyBoxOfficeResponse> getDailyBoxOffice(@Query("targetDt") String targetDt);

    @GET("boxoffice/searchWeeklyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e")
    Call<WeeklyBoxOfficeResponse> getWeeklyBoxOffice(@Query("targetDt") String targetDt);
}
