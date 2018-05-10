package com.wazert.myblog;

import io.reactivex.disposables.Disposable;

/**
 * @author zhaozhuo
 * @date 2018/4/19 15:31
 */
public interface BasePresenter {


    /**
     * 默认初始化
     */
    void start();

    /**
     * 关闭activity 置空view
     */
    void  detach();

    /**
     * 将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
     * @param subscription
     */
    void addDisposable(Disposable subscription);


    /**
     * 注销所有请求
     */
    void unDisposable();

}
