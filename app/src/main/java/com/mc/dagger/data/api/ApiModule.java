package com.mc.dagger.data.api;

import android.app.Application;

import com.mc.dagger.BuildConfig;
import com.mc.dagger.data.remote.ApiManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

@Module
public class ApiModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //添加logo日志打印网络请求的拦截器
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        builder.connectTimeout(30*1000, TimeUnit.MILLISECONDS);
        builder.readTimeout(30*1000,TimeUnit.MILLISECONDS);
        return  builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(client)
                .baseUrl(ApiService.SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit restAdapter){
        return restAdapter.create(ApiService.class);
    }

    @Provides
    @Singleton
    ApiManager provideApiManager(Application application,ApiService apiService){
        return new ApiManager(apiService,application);
    }

}
