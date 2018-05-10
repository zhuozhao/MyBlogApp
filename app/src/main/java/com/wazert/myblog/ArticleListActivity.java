package com.wazert.myblog;

import android.os.Bundle;

import com.wazert.myblog.bean.Chapter;
import com.wazert.myblog.bean.PageData;
import com.wazert.myblog.contract.ArticleListContract;
import com.wazert.myblog.presenter.ArticleListPresenter;

/**
 * 首页文章列表
 */
public class ArticleListActivity extends BaseActivity<ArticleListContract.Presenter> implements ArticleListContract.View {

    private PageData<Chapter> chapterPageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        presenter.getData();
    }

    @Override
    public ArticleListContract.Presenter initPresenter() {
        return new ArticleListPresenter(this);
    }

    @Override
    public void setData(PageData<Chapter> pageData) {
        chapterPageData = pageData;
    }

    @Override
    public void showToast(String text) {

    }
}
