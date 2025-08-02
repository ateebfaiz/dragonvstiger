package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class a extends zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rpc f6635a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(Rpc rpc, Looper looper) {
        super(looper);
        this.f6635a = rpc;
    }

    public final void handleMessage(Message message) {
        Rpc.zzc(this.f6635a, message);
    }
}
