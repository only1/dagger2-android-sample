package com.only1.dagger2.sample.simple;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daehwang on 10/05/2017.
 */

@Module
class NetworkModule {

    @Provides
    MovieApi provideMovieApi() {
        return new Retrofit.Builder()
                .baseUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MovieApi.class);
    }
}
