package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;

final class v1 implements t1 {

    /* renamed from: c  reason: collision with root package name */
    private static v1 f7333c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7334a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentObserver f7335b;

    private v1() {
        this.f7334a = null;
        this.f7335b = null;
    }

    static v1 a(Context context) {
        v1 v1Var;
        v1 v1Var2;
        synchronized (v1.class) {
            try {
                if (f7333c == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        v1Var2 = new v1(context);
                    } else {
                        v1Var2 = new v1();
                    }
                    f7333c = v1Var2;
                }
                v1Var = f7333c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return v1Var;
    }

    static synchronized void d() {
        Context context;
        synchronized (v1.class) {
            try {
                v1 v1Var = f7333c;
                if (!(v1Var == null || (context = v1Var.f7334a) == null || v1Var.f7335b == null)) {
                    context.getContentResolver().unregisterContentObserver(f7333c.f7335b);
                }
                f7333c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final String zzb(String str) {
        Context context = this.f7334a;
        if (context != null && !zzhb.zza(context)) {
            try {
                return (String) zzhi.zza(new zzhl(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e10);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String c(String str) {
        return zzha.zza(this.f7334a.getContentResolver(), str, (String) null);
    }

    private v1(Context context) {
        this.f7334a = context;
        u1 u1Var = new u1(this, (Handler) null);
        this.f7335b = u1Var;
        context.getContentResolver().registerContentObserver(zzha.zza, true, u1Var);
    }
}
