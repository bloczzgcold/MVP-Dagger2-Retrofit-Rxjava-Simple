package com.mc.dagger.data.remote.model;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

public class BaseResponseFunc<T> implements Func1<BaseResponse<T>, Observable<T>> {

    @Override
    public Observable<T> call(BaseResponse<T> tBaseResponse) {
        //遇到非200错误统一处理,将BaseResponse转换成您想要的对象
        if (tBaseResponse.getStatus() != 1) {
            return Observable.error(new Throwable(tBaseResponse.getMsg()));
        }else{
            return Observable.just(tBaseResponse.getData());
        }
    }
}
