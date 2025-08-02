package com.facebook.react.modules.network;

import android.content.Context;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static OkHttpClient f3327a;

    public static OkHttpClient a() {
        return c().build();
    }

    public static OkHttpClient b(Context context) {
        return d(context).build();
    }

    public static OkHttpClient.Builder c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(0, timeUnit).readTimeout(0, timeUnit).writeTimeout(0, timeUnit).cookieJar(new m());
    }

    public static OkHttpClient.Builder d(Context context) {
        return e(context, 10485760);
    }

    public static OkHttpClient.Builder e(Context context, int i10) {
        OkHttpClient.Builder c10 = c();
        if (i10 == 0) {
            return c10;
        }
        return c10.cache(new Cache(new File(context.getCacheDir(), "http-cache"), (long) i10));
    }

    public static OkHttpClient f() {
        if (f3327a == null) {
            f3327a = a();
        }
        return f3327a;
    }
}
