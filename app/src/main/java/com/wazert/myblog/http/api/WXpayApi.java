package com.wazert.myblog.http.api;

import com.wazert.myblog.bean.PayOrder;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author zhaozhuo
 * @date 2018/3/28 10:55
 */

public interface WXpayApi {

    @GET("pub_v2/app/app_pay.php")
    Call<PayOrder> appPay();

}
