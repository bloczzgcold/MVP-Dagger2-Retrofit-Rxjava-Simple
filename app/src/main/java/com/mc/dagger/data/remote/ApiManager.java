package com.mc.dagger.data.remote;

import android.app.Application;

import com.mc.dagger.data.api.ApiService;
import com.mc.dagger.data.remote.model.BaseResponseFunc;
import com.mc.dagger.data.remote.model.book.Book;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

public class ApiManager {
    private final ApiService apiService;
    private final Application application;
    public ApiManager(ApiService apiService, Application application){
        this.apiService = apiService;
        this.application = application;
    }

    public void getBookById(String bookId, SimpleCallback<Book> callback){
        apiService.getBookById(bookId)
                .flatMap(new BaseResponseFunc<Book>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ExceptionSubscriber<Book>(callback,application));
    }

    public void getAllBooks(SimpleCallback<List<Book>> callback){
        apiService.getAllBooks()
                .flatMap(new BaseResponseFunc<List<Book>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ExceptionSubscriber<List<Book>>(callback,application));
    }
}
