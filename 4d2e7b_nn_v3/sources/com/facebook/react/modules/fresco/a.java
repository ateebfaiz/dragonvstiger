package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.os.SystemClock;
import com.facebook.imagepipeline.producers.x0;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import v4.b;

class a extends b {

    /* renamed from: e  reason: collision with root package name */
    private final OkHttpClient f3288e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f3289f;

    public a(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.f3288e = okHttpClient;
        this.f3289f = okHttpClient.dispatcher().executorService();
    }

    private Map n(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, readableMap.getString(nextKey));
        }
        return hashMap;
    }

    /* renamed from: i */
    public void d(b.C0347b bVar, x0.a aVar) {
        Map map;
        bVar.f24399f = SystemClock.elapsedRealtime();
        Uri g10 = bVar.g();
        if (bVar.b().b() instanceof z6.a) {
            map = n(((z6.a) bVar.b().b()).A());
        } else {
            map = null;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        j(bVar, aVar, new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(g10.toString()).headers(Headers.of((Map<String, String>) map)).get().build());
    }
}
