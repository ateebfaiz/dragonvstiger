package com.facebook.react.modules.network;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e extends CookieHandler {

    /* renamed from: a  reason: collision with root package name */
    private final ReactContext f3321a;

    /* renamed from: b  reason: collision with root package name */
    private CookieManager f3322b;

    public e(ReactContext reactContext) {
        this.f3321a = reactContext;
    }

    private void b(String str, String str2) {
        CookieManager f10 = f();
        if (f10 != null) {
            f10.setCookie(str, str2, (ValueCallback) null);
        }
    }

    private CookieManager f() {
        if (this.f3322b == null) {
            try {
                this.f3322b = CookieManager.getInstance();
            } catch (Exception | IllegalArgumentException unused) {
                return null;
            }
        }
        return this.f3322b;
    }

    private static boolean g(String str) {
        if (str.equalsIgnoreCase("Set-cookie") || str.equalsIgnoreCase("Set-cookie2")) {
            return true;
        }
        return false;
    }

    public void c(String str, List list) {
        CookieManager f10 = f();
        if (f10 != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b(str, (String) it.next());
            }
            f10.flush();
        }
    }

    public void d(Callback callback) {
        CookieManager f10 = f();
        if (f10 != null) {
            f10.removeAllCookies(new d(callback));
        }
    }

    public void e() {
    }

    public Map get(URI uri, Map map) {
        CookieManager f10 = f();
        if (f10 == null) {
            return Collections.emptyMap();
        }
        String cookie = f10.getCookie(uri.toString());
        if (TextUtils.isEmpty(cookie)) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap("Cookie", Collections.singletonList(cookie));
    }

    public void put(URI uri, Map map) {
        String uri2 = uri.toString();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null && g(str)) {
                c(uri2, (List) entry.getValue());
            }
        }
    }
}
