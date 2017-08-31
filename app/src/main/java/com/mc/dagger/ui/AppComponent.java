package com.mc.dagger.ui;

import com.mc.dagger.data.api.ApiModule;
import com.mc.dagger.ui.component.MainComponent;
import com.mc.dagger.ui.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

@Singleton
@Component(modules = {AppModule.class,ApiModule.class})
public interface AppComponent {

    MainComponent plus(MainModule mainModule);

}
