package com.mc.dagger.ui;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return this.application;
    }
}
