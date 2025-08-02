package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.a;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    static final c f6569a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    static abstract class a {
        a() {
        }

        /* access modifiers changed from: package-private */
        public abstract c a();

        /* access modifiers changed from: package-private */
        public abstract a b(int i10);

        /* access modifiers changed from: package-private */
        public abstract a c(long j10);

        /* access modifiers changed from: package-private */
        public abstract a d(int i10);

        /* access modifiers changed from: package-private */
        public abstract a e(int i10);

        /* access modifiers changed from: package-private */
        public abstract a f(long j10);
    }

    c() {
    }

    static a a() {
        return new a.b();
    }

    /* access modifiers changed from: package-private */
    public abstract int b();

    /* access modifiers changed from: package-private */
    public abstract long c();

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract long f();
}
