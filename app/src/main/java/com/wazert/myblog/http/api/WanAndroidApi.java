package com.wazert.myblog.http.api;

import com.wazert.myblog.bean.Chapter;
import com.wazert.myblog.bean.PageData;
import com.wazert.myblog.bean.Result;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author zhaozhuo
 * @date 2018/4/19 11:30
 */
public interface WanAndroidApi {

    /**
     * 获取首页文章列表
     * @param pageNum 页码
     * @return
     */
    @GET("article/list/{pageNum}/json")
    Observable<Result<PageData<Chapter>>> articleList(@Path("pageNum") int pageNum);


    @GET("api/account/send_verify_code.do")
    Observable<Result<Chapter>> send_verify_code(@Query("mobile") String mobile,@Query("deviceType") String deviceType);

}
