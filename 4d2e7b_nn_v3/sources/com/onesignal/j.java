package com.onesignal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10703a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static ApplicationInfo f10704b;

    public static final class a {
        private a() {
        }

        public final ApplicationInfo a(Context context) {
            m.f(context, "context");
            if (j.f10704b != null) {
                return j.f10704b;
            }
            try {
                j.f10704b = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                return j.f10704b;
            } catch (RuntimeException e10) {
                if (i.a(e10.getCause())) {
                    return null;
                }
                throw e10;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
