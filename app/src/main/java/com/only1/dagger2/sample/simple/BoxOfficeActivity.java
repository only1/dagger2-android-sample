package com.only1.dagger2.sample.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.only1.dagger2.sample.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BoxOfficeActivity extends AppCompatActivity implements BoxOfficeConstract.View {
    private static final String TAG = BoxOfficeActivity.class.getSimpleName();

    @Inject
    BoxOfficeConstract.Presenter boxOfficePresenter;

    @BindView(R.id.boxoffice_title)
    TextView title;

    @BindView(R.id.boxoffice_contnet)
    TextView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxoffice);
        ButterKnife.bind(this);

        ((MyApplication)getApplication()).getAppComponent().inject(this);
        boxOfficePresenter.setView(this);
    }

    @OnClick(R.id.boxoffice_get_daily_info)
    public void showDailyBoxOffice() {
        Log.d(TAG, "showDailyBoxOffice called");
        boxOfficePresenter.loadDailyBoxOffice();
    }

    @OnClick(R.id.boxoffice_get_weekly_info)
    public void showWeeklyBoxOffice() {
        Log.d(TAG, "showWeeklyBoxOffice called");
        boxOfficePresenter.loadWeeklyBoxOffice();
    }

    @Override
    public void showTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void showContents(String content) {
        this.content.setText(content);
    }
}
