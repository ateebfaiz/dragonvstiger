package com.onesignal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class f4 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10638a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final y a(Context context, String str, int i10) {
            m.f(context, "appContext");
            m.f(str, "packageName");
            try {
                return new y(true, context.getPackageManager().getPackageInfo(str, i10));
            } catch (PackageManager.NameNotFoundException unused) {
                return new y(true, (PackageInfo) null);
            } catch (RuntimeException e10) {
                if (i.a(e10.getCause())) {
                    return new y(false, (PackageInfo) null);
                }
                throw e10;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
