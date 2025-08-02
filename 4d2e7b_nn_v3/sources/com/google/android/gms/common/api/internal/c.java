package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class c implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f6671a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f6672b;

    c(zaad zaad, BasePendingResult basePendingResult) {
        this.f6672b = zaad;
        this.f6671a = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.f6672b.zaa.remove(this.f6671a);
    }
}
