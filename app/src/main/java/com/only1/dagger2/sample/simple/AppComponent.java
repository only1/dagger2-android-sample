package com.only1.dagger2.sample.simple;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by daehwang on 10/05/2017.
 */

@Singleton
@Component(modules = {AppModule.class, PresentModule.class, NetworkModule.class})
interface AppComponent {
    void inject(BoxOfficeActivity target);
    void inject(BoxOfficePresenter target);
}
