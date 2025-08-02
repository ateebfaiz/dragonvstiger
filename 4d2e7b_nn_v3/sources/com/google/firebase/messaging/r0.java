package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class r0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9281a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f9282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d0 f9284d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a0 f9285e;

    public /* synthetic */ r0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, d0 d0Var, a0 a0Var) {
        this.f9281a = context;
        this.f9282b = scheduledExecutorService;
        this.f9283c = firebaseMessaging;
        this.f9284d = d0Var;
        this.f9285e = a0Var;
    }

    public final Object call() {
        return s0.j(this.f9281a, this.f9282b, this.f9283c, this.f9284d, this.f9285e);
    }
}
