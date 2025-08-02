package com.th3rdwave.safeareacontext;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.v;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReentrantLock f11720a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f11721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Condition f11722c;

    public /* synthetic */ i(ReentrantLock reentrantLock, v vVar, Condition condition) {
        this.f11720a = reentrantLock;
        this.f11721b = vVar;
        this.f11722c = condition;
    }

    public final void run() {
        SafeAreaView.w(this.f11720a, this.f11721b, this.f11722c);
    }
}
