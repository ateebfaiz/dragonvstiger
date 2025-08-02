package com.facebook.react.uimanager;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import kotlin.jvm.internal.m;

public class s extends JSApplicationCausedNativeException {

    /* renamed from: a  reason: collision with root package name */
    private View f3912a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(String str) {
        super(str);
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(String str, View view, Throwable th) {
        super(str, th);
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        m.f(th, "cause");
        this.f3912a = view;
    }
}
