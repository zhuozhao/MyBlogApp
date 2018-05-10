package com.wazert.myblog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wazert.myblog.app.Constants;

/**
 * @author zhaozhuo
 * @date 2018/3/23 10:24
 */

public class AppRegister extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final IWXAPI iwxapi = WXAPIFactory.createWXAPI(context,null);
        //将app注册到微信
        iwxapi.registerApp(Constants.APP_ID);
    }
}
