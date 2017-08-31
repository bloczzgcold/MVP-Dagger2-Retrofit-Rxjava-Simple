package com.mc.dagger.ui;

import android.app.Activity;
import android.os.Bundle;

import com.mc.dagger.App;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this).getAppComponent());
    }
    protected abstract  void setupActivityComponent(AppComponent appComponent);
}
