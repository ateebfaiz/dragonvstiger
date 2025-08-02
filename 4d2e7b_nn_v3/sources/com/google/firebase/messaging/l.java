package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class l implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9248a;

    public /* synthetic */ l(String str) {
        this.f9248a = str;
    }

    public final Task then(Object obj) {
        return ((s0) obj).r(this.f9248a);
    }
}
