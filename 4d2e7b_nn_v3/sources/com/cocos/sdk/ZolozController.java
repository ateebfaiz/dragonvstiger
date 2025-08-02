package com.cocos.sdk;

import android.content.Context;
import com.facebook.react.bridge.Callback;

public class ZolozController {
    private static final String TAG = "ZolozController";
    private static final ZolozController instance = new ZolozController();

    private ZolozController() {
    }

    public static ZolozController getInstance() {
        return instance;
    }

    public String getZlzMetaInfo(Context context) {
        return "";
    }

    public void initZlz(Context context, String str, String str2, String str3) {
    }

    public void initZlz(Context context, String str, String str2, String str3, Callback callback) {
    }
}
