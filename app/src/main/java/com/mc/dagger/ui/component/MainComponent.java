package com.mc.dagger.ui.component;

import com.mc.dagger.ui.activity.MainActivity;
import com.mc.dagger.ui.module.MainModule;

import dagger.Subcomponent;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);

}
