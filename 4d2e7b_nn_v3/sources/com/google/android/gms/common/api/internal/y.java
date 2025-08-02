package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class y extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabi f6754a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    y(zabi zabi, Looper looper) {
        super(looper);
        this.f6754a = zabi;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            ((x) message.obj).b(this.f6754a);
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i10);
            Log.w("GACStateManager", sb2.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
