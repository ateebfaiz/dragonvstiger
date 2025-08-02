package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zaq;

final class q0 extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zada f6730a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(zada zada, Looper looper) {
        super(looper);
        this.f6730a = zada;
    }

    public final void handleMessage(Message message) {
        String str;
        int i10 = message.what;
        if (i10 == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.f6730a.zae) {
                try {
                    zada zada = (zada) Preconditions.checkNotNull(this.f6730a.zab);
                    if (pendingResult == null) {
                        zada.zaj(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zacp) {
                        zada.zaj(((zacp) pendingResult).zaa());
                    } else {
                        zada.zai(pendingResult);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder(70);
            sb2.append("TransformationResultHandler received unknown message type: ");
            sb2.append(i10);
            Log.e("TransformedResultImpl", sb2.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            if (valueOf.length() != 0) {
                str = "Runtime exception on the transformation worker thread: ".concat(valueOf);
            } else {
                str = new String("Runtime exception on the transformation worker thread: ");
            }
            Log.e("TransformedResultImpl", str);
            throw runtimeException;
        }
    }
}
