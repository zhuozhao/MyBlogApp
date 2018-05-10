package com.wazert.myblog;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author zhaozhuo
 * @date 2018/4/19 15:35
 */
public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    protected V view;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenterImpl(V view){
        this.view =view;
        start();
    }

    @Override
    public void detach() {

        view =null;
        unDisposable();
    }


    @Override
    public void start() {

    }

    @Override
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
}
