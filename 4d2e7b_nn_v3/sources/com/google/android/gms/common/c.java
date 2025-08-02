package com.google.android.gms.common;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class c extends zaq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6758a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ GoogleApiAvailability f6759b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(com.google.android.gms.common.GoogleApiAvailability r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.f6759b = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x000d
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L_0x0011
        L_0x000d:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L_0x0011:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.f6758a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.c.<init>(com.google.android.gms.common.GoogleApiAvailability, android.content.Context):void");
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i10);
            Log.w("GoogleApiAvailability", sb2.toString());
            return;
        }
        int isGooglePlayServicesAvailable = this.f6759b.isGooglePlayServicesAvailable(this.f6758a);
        if (this.f6759b.isUserResolvableError(isGooglePlayServicesAvailable)) {
            this.f6759b.showErrorNotification(this.f6758a, isGooglePlayServicesAvailable);
        }
    }
}
