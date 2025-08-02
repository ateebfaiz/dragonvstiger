package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import kotlin.jvm.internal.m;

public abstract class p {
    public static final ReactContext a(View view) {
        m.f(view, "view");
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        return (ReactContext) context;
    }

    public static final int b(Context context) {
        m.f(context, "context");
        return -1;
    }
}
