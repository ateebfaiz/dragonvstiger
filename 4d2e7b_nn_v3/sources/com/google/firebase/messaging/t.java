package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class t implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9297a;

    public /* synthetic */ t(String str) {
        this.f9297a = str;
    }

    public final Task then(Object obj) {
        return ((s0) obj).u(this.f9297a);
    }
}
