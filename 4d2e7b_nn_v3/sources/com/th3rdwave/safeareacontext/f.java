package com.th3rdwave.safeareacontext;

import android.content.Context;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import kotlin.jvm.internal.m;

public abstract class f {
    /* access modifiers changed from: private */
    public static final void b(SafeAreaProvider safeAreaProvider, a aVar, c cVar) {
        Context context = safeAreaProvider.getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int id2 = safeAreaProvider.getId();
        e c10 = k1.c(reactContext, id2);
        if (c10 != null) {
            c10.c(new b(p.b(reactContext), id2, aVar, cVar));
        }
    }
}
