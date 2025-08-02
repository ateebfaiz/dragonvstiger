package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class v extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabe f6747a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(zabe zabe, Looper looper) {
        super(looper);
        this.f6747a = zabe;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            zabe.zaj(this.f6747a);
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i10);
            Log.w("GoogleApiClientImpl", sb2.toString());
        } else {
            zabe.zai(this.f6747a);
        }
    }
}
