package com.mc.dagger;

import android.app.Application;
import android.content.Context;

import com.mc.dagger.data.api.ApiModule;
import com.mc.dagger.ui.AppComponent;
import com.mc.dagger.ui.AppModule;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

public class App extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = com.mc.dagger.ui.DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public static App get(Context context){
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
