package com.mc.dagger.data.remote;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

public interface SimpleCallback<T> {
    void onStart();

    void onNext(T t);

    void onComplete();
}
