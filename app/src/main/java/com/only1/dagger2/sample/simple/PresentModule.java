package com.only1.dagger2.sample.simple;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by daehwang on 10/05/2017.
 */

@Module
class PresentModule {

    @Provides
    BoxOfficeConstract.Presenter provideBoxOfficePresenter(Context context) {
        return new BoxOfficePresenter(context);
    }
}
