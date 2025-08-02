package com.facebook.react.modules.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;

public class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private CookieJar f3339a = null;

    public void a() {
        this.f3339a = null;
    }

    public void b(CookieJar cookieJar) {
        this.f3339a = cookieJar;
    }

    public List loadForRequest(HttpUrl httpUrl) {
        CookieJar cookieJar = this.f3339a;
        if (cookieJar == null) {
            return Collections.emptyList();
        }
        List<Cookie> loadForRequest = cookieJar.loadForRequest(httpUrl);
        ArrayList arrayList = new ArrayList();
        for (Cookie next : loadForRequest) {
            try {
                new Headers.Builder().add(next.name(), next.value());
                arrayList.add(next);
            } catch (IllegalArgumentException unused) {
            }
        }
        return arrayList;
    }

    public void saveFromResponse(HttpUrl httpUrl, List list) {
        CookieJar cookieJar = this.f3339a;
        if (cookieJar != null) {
            cookieJar.saveFromResponse(httpUrl, list);
        }
    }
}
