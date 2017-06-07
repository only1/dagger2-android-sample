package com.only1.dagger2.sample.simple;

import android.app.Application;

/**
 * Created by daehwang on 10/05/2017.
 */

public class MyApplication extends Application{

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(MyApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .networkModule(new NetworkModule())
                .presentModule(new PresentModule()).build();
    }
}
