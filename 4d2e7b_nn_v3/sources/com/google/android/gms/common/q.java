package com.google.android.gms.common;

import android.util.Log;

class q {

    /* renamed from: e  reason: collision with root package name */
    private static final q f6826e = new q(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f6827a;

    /* renamed from: b  reason: collision with root package name */
    final String f6828b;

    /* renamed from: c  reason: collision with root package name */
    final Throwable f6829c;

    /* renamed from: d  reason: collision with root package name */
    final int f6830d;

    private q(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f6827a = z10;
        this.f6830d = i10;
        this.f6828b = str;
        this.f6829c = th;
    }

    static q b() {
        return f6826e;
    }

    static q c(String str) {
        return new q(false, 1, 5, str, (Throwable) null);
    }

    static q d(String str, Throwable th) {
        return new q(false, 1, 5, str, th);
    }

    static q f(int i10) {
        return new q(true, i10, 1, (String) null, (Throwable) null);
    }

    static q g(int i10, int i11, String str, Throwable th) {
        return new q(false, i10, i11, str, th);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f6828b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f6827a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f6829c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f6829c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }

    /* synthetic */ q(boolean z10, int i10, int i11, String str, Throwable th, zzw zzw) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }
}
