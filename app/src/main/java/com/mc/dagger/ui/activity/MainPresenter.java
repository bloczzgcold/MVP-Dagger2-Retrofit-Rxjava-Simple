package com.mc.dagger.ui.activity;

import com.mc.dagger.data.remote.ApiManager;
import com.mc.dagger.data.remote.SimpleCallback;
import com.mc.dagger.data.remote.model.book.Book;
import com.mc.dagger.ui.activity.MainContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

public class MainPresenter {

    private MainContract.MainView view;

    private ApiManager mApiManager;
    @Inject
    public MainPresenter(MainContract.MainView view, ApiManager apiManager){
        this.view = view;
        mApiManager = apiManager;
    }

    public void findBookById(){
        mApiManager.getBookById("1", new SimpleCallback<Book>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onNext(Book book) {
                view.updateName("book info----->"+book.toString());
            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void findAllBooks(){
        mApiManager.getAllBooks(new SimpleCallback<List<Book>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onNext(List<Book> books) {
                view.showAllBooks(books);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
