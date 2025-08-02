package com.facebook.login;

import android.net.Uri;
import v5.a;

public class c extends i {

    /* renamed from: n  reason: collision with root package name */
    private static volatile c f20485n;

    /* renamed from: m  reason: collision with root package name */
    private Uri f20486m;

    public static c H() {
        if (a.d(c.class)) {
            return null;
        }
        try {
            if (f20485n == null) {
                synchronized (c.class) {
                    if (f20485n == null) {
                        f20485n = new c();
                    }
                }
            }
            return f20485n;
        } catch (Throwable th) {
            a.b(th, c.class);
            return null;
        }
    }

    public void I(Uri uri) {
        if (!a.d(this)) {
            try {
                this.f20486m = uri;
            } catch (Throwable th) {
                a.b(th, this);
            }
        }
    }
}
