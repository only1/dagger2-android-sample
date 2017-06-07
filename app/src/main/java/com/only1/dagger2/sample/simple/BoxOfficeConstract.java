package com.only1.dagger2.sample.simple;

/**
 * Created by daehwang on 10/05/2017.
 */

final class BoxOfficeConstract {

    private BoxOfficeConstract() {}

    interface View {
        void showTitle(String title);
        void showContents(String content);
    }

    interface Presenter {
        void setView(View view);
        void loadDailyBoxOffice();
        void loadWeeklyBoxOffice();
    }
}
