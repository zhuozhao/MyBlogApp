package com.wazert.myblog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zhaozhuo
 * @date 2018/4/19 15:41
 */
public abstract class BaseActivity<P extends  BasePresenter> extends AppCompatActivity implements BaseView {


    protected   P presenter;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        presenter = initPresenter();
    }

    public abstract P initPresenter();


    @Override
    public void loading() {

    }

    @Override
    public void closeLoading() {

    }
}
