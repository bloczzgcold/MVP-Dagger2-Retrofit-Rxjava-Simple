package com.mc.dagger.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.mc.dagger.App;
import com.mc.dagger.R;
import com.mc.dagger.data.remote.model.book.Book;
import com.mc.dagger.ui.AppComponent;
import com.mc.dagger.ui.BaseActivity;
import com.mc.dagger.ui.contract.MainContract;
import com.mc.dagger.ui.module.MainModule;
import com.mc.dagger.ui.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.MainView{

    private TextView tvMain;
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = (TextView) findViewById(R.id.tv_main);
        presenter.findBookById();
        presenter.findAllBooks();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        App.get(this).getAppComponent().plus(new MainModule(this))
                .inject(this);
    }

    @Override
    public void updateName(String name) {
        tvMain.setText(name);
    }

    @Override
    public void showAllBooks(List<Book> books) {
        tvMain.append("\n");
        tvMain.append(books.toString());
    }

}
