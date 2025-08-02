package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.z0;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f3618a = new m();

    private m() {
    }

    public static final void a(View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.m.f(view, "view");
        kotlin.jvm.internal.m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        z0 a10 = a1.a(view);
        if (a10 != null) {
            a10.c(view, motionEvent);
        }
    }

    public static final void b(View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.m.f(view, "view");
        kotlin.jvm.internal.m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        z0 a10 = a1.a(view);
        if (a10 != null) {
            a10.a(view, motionEvent);
        }
    }
}
