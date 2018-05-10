package com.wazert.myblog;

/**
 * @author zhaozhuo
 * @date 2018/4/19 15:28
 */
public interface BaseView {

    /**
     * 加载
     */
    void loading();

    /**
     * 关闭加载
     */
    void closeLoading();


    /**
     * 显示toast
     * @param text
     */
    void showToast(String text);
}
