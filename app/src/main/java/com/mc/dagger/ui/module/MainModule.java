package com.mc.dagger.ui.module;

import com.mc.dagger.data.remote.ApiManager;
import com.mc.dagger.ui.activity.MainContract;
import com.mc.dagger.ui.activity.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

@Module
public class MainModule {
    private final MainContract.MainView view;

    public MainModule(MainContract.MainView view){
        this.view = view;
    }

    @Provides
    MainContract.MainView provideMainView(){
        return view;
    }

    @Provides
    MainPresenter provideMainPresenter(MainContract.MainView view, ApiManager apiManager){
        return new MainPresenter(view,apiManager);
    }
}
