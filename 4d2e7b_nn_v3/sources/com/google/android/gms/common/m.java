package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class m extends k {

    /* renamed from: e  reason: collision with root package name */
    private static final WeakReference f6815e = new WeakReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f6816b = f6815e;

    m(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] N() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.f6816b.get();
                if (bArr == null) {
                    bArr = O();
                    this.f6816b = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] O();
}
