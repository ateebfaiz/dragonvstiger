package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;

class z {

    /* renamed from: a  reason: collision with root package name */
    private final GoogleApiClient f11116a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f11117b;

    z(GoogleApiClient googleApiClient) {
        this.f11116a = googleApiClient;
        this.f11117b = googleApiClient.getClass();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            this.f11117b.getMethod("connect", (Class[]) null).invoke(this.f11116a, (Object[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        try {
            this.f11117b.getMethod("disconnect", (Class[]) null).invoke(this.f11116a, (Object[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public GoogleApiClient c() {
        return this.f11116a;
    }
}
