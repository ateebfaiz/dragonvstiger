package com.livechatinc.inappchat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;

public abstract class f {
    public static void a(Context context) {
        WebStorage.getInstance().deleteAllData();
        CookieManager.getInstance().removeAllCookies((ValueCallback) null);
        CookieManager.getInstance().flush();
    }

    public static g b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        ChatWindowViewImpl chatWindowViewImpl = (ChatWindowViewImpl) LayoutInflater.from(activity).inflate(i.f10146a, viewGroup, false);
        viewGroup.addView(chatWindowViewImpl, -1, -1);
        return chatWindowViewImpl;
    }
}
