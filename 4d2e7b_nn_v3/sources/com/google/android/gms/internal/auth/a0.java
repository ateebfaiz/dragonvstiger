package com.google.android.gms.internal.auth;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;

final class a0 implements y {

    /* renamed from: c  reason: collision with root package name */
    private static a0 f6887c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f6888a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentObserver f6889b;

    private a0() {
        this.f6888a = null;
        this.f6889b = null;
    }

    static a0 a(Context context) {
        a0 a0Var;
        a0 a0Var2;
        synchronized (a0.class) {
            try {
                if (f6887c == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        a0Var2 = new a0(context);
                    } else {
                        a0Var2 = new a0();
                    }
                    f6887c = a0Var2;
                }
                a0Var = f6887c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a0Var;
    }

    static synchronized void d() {
        Context context;
        synchronized (a0.class) {
            try {
                a0 a0Var = f6887c;
                if (!(a0Var == null || (context = a0Var.f6888a) == null || a0Var.f6889b == null)) {
                    context.getContentResolver().unregisterContentObserver(f6887c.f6889b);
                }
                f6887c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final String zzb(String str) {
        Context context = this.f6888a;
        if (context != null && !zzcc.zza(context)) {
            try {
                return (String) zzcj.zza(new zzcm(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e10);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String c(String str) {
        return zzcb.zza(this.f6888a.getContentResolver(), str, (String) null);
    }

    private a0(Context context) {
        this.f6888a = context;
        z zVar = new z(this, (Handler) null);
        this.f6889b = zVar;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, zVar);
    }
}
