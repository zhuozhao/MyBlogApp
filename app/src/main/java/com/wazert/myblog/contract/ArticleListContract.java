package com.wazert.myblog.contract;

import com.wazert.myblog.BasePresenter;
import com.wazert.myblog.BaseView;
import com.wazert.myblog.bean.Chapter;
import com.wazert.myblog.bean.PageData;

/**
 * @author zhaozhuo
 * @date 2018/4/19 15:56
 */
public interface ArticleListContract {

    interface View extends BaseView{

        void setData(PageData<Chapter> pageData);
    }

    interface Presenter extends BasePresenter{

        void getData();
    }
}
