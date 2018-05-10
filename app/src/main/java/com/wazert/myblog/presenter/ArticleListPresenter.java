package com.wazert.myblog.presenter;

import android.util.Log;

import com.wazert.myblog.BasePresenterImpl;
import com.wazert.myblog.bean.Chapter;
import com.wazert.myblog.bean.PageData;
import com.wazert.myblog.bean.Result;
import com.wazert.myblog.contract.ArticleListContract;
import com.wazert.myblog.http.WanAndroidService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author zhaozhuo
 * @date 2018/4/19 16:21
 */
public class ArticleListPresenter extends BasePresenterImpl<ArticleListContract.View> implements ArticleListContract.Presenter {

    private static final String TAG = "ArticleListPresenter";

    public ArticleListPresenter(ArticleListContract.View view) {
        super(view);
    }

    @Override
    public void getData() {


        Observable<Result<PageData<Chapter>>> observable = WanAndroidService.getWanAndroidApi().articleList(0);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<PageData<Chapter>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Result<PageData<Chapter>> pageDataResult) {

                        Log.d(TAG, "onNext: ");
                        view.setData(pageDataResult.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });

    }

}
