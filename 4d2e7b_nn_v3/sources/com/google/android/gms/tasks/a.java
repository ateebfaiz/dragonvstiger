package com.google.android.gms.tasks;

final class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ OnTokenCanceledListener f7826a;

    a(g gVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.f7826a = onTokenCanceledListener;
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        this.f7826a.onCanceled();
    }
}
