package com.wazert.myblog.http;

import com.wazert.myblog.http.api.WXpayApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zhaozhuo
 * @date 2018/3/28 10:54
 */

public class WXpayService {


    private static final long DEFAULT_TIMEOUT = 30;
    private static WXpayApi wXpayApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    private static Retrofit iniOkHttpClient() {

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = okHttpClient.newBuilder()
                .addInterceptor(logging)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .header("User-Agent", "(android; zh-cn) okhttp")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://wxpay.wxutil.com/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();

        return retrofit;

    }



    /**
     * 获取微信支付
     * @return
     */
    public static  WXpayApi getwXpayApi(){
        if(wXpayApi==null){
            wXpayApi = iniOkHttpClient().create(WXpayApi.class);
        }
        return  wXpayApi;
    }

}
