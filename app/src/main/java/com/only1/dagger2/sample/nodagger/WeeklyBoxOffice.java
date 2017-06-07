package com.only1.dagger2.sample.nodagger;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by daehwang on 10/05/2017.
 */

class WeeklyBoxOffice {
    @SerializedName("boxofficeType") String boxofficeType;
    @SerializedName("showRange") String showRange;
    @SerializedName("weeklyBoxOfficeList") List<Movie> weeklyBoxOfficeList;
}