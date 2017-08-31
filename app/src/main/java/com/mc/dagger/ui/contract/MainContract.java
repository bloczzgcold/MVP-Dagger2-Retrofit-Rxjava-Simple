package com.mc.dagger.ui.contract;

import com.mc.dagger.data.remote.model.book.Book;

import java.util.List;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

public interface MainContract {
    interface MainView{
        void updateName(String name);

        void showAllBooks(List<Book> books);
    }
}
