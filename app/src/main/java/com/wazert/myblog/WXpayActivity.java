package com.wazert.myblog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wazert.myblog.R;
import com.wazert.myblog.app.Constants;
import com.wazert.myblog.bean.PayOrder;
import com.wazert.myblog.http.WXpayService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 微信支付
 */
public class WXpayActivity extends AppCompatActivity {

    private static final String TAG = "WXpayActivity";
    private String url = "http://wxpay.wxutil.com/pub_v2/app/app_pay.php";
    private IWXAPI iwxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay);

        iwxapi = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
        iwxapi.registerApp(Constants.APP_ID);

    }

    /**
     * 点击微信支付
     *
     * @param view
     */
    public void wxpay(View view) {


        WXpayService.getwXpayApi().appPay().enqueue(new Callback<PayOrder>() {
            @Override
            public void onResponse(Call<PayOrder> call, Response<PayOrder> response) {

                Log.d(TAG, "onResponse:  "+response.toString());
                PayOrder payOrder = response.body();
                PayReq req = new PayReq();
                req.appId = payOrder.getAppid();
                req.partnerId = payOrder.getPartnerid();
                req.prepayId = payOrder.getPartnerid();
                req.nonceStr = payOrder.getNoncestr();
                req.timeStamp = payOrder.getTimestamp();
                req.packageValue = payOrder.getPackageX();
                req.sign = payOrder.getSign();
                req.extData = "app data";
                iwxapi.sendReq(req);
            }

            @Override
            public void onFailure(Call<PayOrder> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.toString());
            }
        });


    }


}
