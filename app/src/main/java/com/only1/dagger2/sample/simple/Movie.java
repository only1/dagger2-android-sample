package com.only1.dagger2.sample.simple;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daehwang on 10/05/2017.
 */

class Movie {
    @SerializedName("rank") String rank;
    @SerializedName("movieNm") String movieNm;
    @SerializedName("salesShare") String salesShare;
}
