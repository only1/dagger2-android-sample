package com.only1.dagger2.sample.simple;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by daehwang on 10/05/2017.
 */

class BoxOfficePresenter implements BoxOfficeConstract.Presenter {
    private static final String TAG = BoxOfficePresenter.class.getSimpleName();

    BoxOfficeConstract.View boxofficeView;

    @Inject
    MovieApi movieApi;

    BoxOfficePresenter(Context context) {
        ((MyApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void setView(BoxOfficeConstract.View view) {
        this.boxofficeView = view;
    }

    @Override
    public void loadDailyBoxOffice() {
        movieApi.getDailyBoxOffice("20170501").enqueue(new Callback<DailyBoxOfficeResponse>() {
            @Override
            public void onResponse(Call<DailyBoxOfficeResponse> call, Response<DailyBoxOfficeResponse> response) {
                Log.d(TAG, "[onResponse] called");
                DailyBoxOfficeResponse dailyBoxOfficeResponse = response.body();

                final String titleFormat = "[%s] %s";
                boxofficeView.showTitle(String.format(titleFormat,
                        dailyBoxOfficeResponse.dailyBoxOffice.boxofficeType,
                        dailyBoxOfficeResponse.dailyBoxOffice.showRange));

                final String contentLineFormat = "[%s] %s (%s)";
                StringBuilder builder = new StringBuilder();

                for (Movie movie : dailyBoxOfficeResponse.dailyBoxOffice.dailyBoxOfficeList) {
                    builder.append(String.format(contentLineFormat, movie.rank, movie.movieNm, movie.salesShare)).append("\n");
                }
                boxofficeView.showContents(builder.toString());
            }

            @Override
            public void onFailure(Call<DailyBoxOfficeResponse> call, Throwable t) {
                Log.d(TAG, "[onFailure] called");
            }
        });
    }


    @Override
    public void loadWeeklyBoxOffice() {
        movieApi.getWeeklyBoxOffice("20170501").enqueue(new Callback<WeeklyBoxOfficeResponse>() {
            @Override
            public void onResponse(Call<WeeklyBoxOfficeResponse> call, Response<WeeklyBoxOfficeResponse> response) {
                WeeklyBoxOfficeResponse weeklyBoxOfficeResponse = response.body();

                final String titleFormat = "[%s] %s";
                boxofficeView.showTitle(String.format(titleFormat,
                        weeklyBoxOfficeResponse.weeklyBoxOffice.boxofficeType,
                        weeklyBoxOfficeResponse.weeklyBoxOffice.showRange));

                final String contentLineFormat = "[%s] %s (%s)";
                StringBuilder builder = new StringBuilder();

                for (Movie movie : weeklyBoxOfficeResponse.weeklyBoxOffice.weeklyBoxOfficeList) {
                    builder.append(String.format(contentLineFormat, movie.rank, movie.movieNm, movie.salesShare)).append("\n");
                }
                boxofficeView.showContents(builder.toString());
            }

            @Override
            public void onFailure(Call<WeeklyBoxOfficeResponse> call, Throwable t) {
                Log.d(TAG, "[onFailure] called");
            }
        });
    }
}
