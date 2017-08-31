package com.mc.dagger.data.api;

import com.mc.dagger.data.remote.model.BaseResponse;
import com.mc.dagger.data.remote.model.book.Book;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangzhenguo on 2017/8/30.
 */

public interface ApiService {
    public static final String SERVER_URL = "http://192.168.1.82:8080/commcssm/";

    @GET("book/findBookById")
        Observable<BaseResponse<Book>> getBookById(@Query("bookId") String bookId);

    @GET("book/selectAllBooks")
    Observable<BaseResponse<List<Book>>> getAllBooks();
}
