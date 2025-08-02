package com.facebook.imagepipeline.producers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import r2.d;
import x4.k;
import x4.x;

public final class g extends i {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20085d = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(x xVar, k kVar, d1 d1Var) {
        super(xVar, kVar, d1Var);
        m.f(xVar, "memoryCache");
        m.f(kVar, "cacheKeyFactory");
        m.f(d1Var, "inputProducer");
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "pipe_ui";
    }

    /* access modifiers changed from: protected */
    public String e() {
        return "BitmapMemoryCacheGetProducer";
    }

    /* access modifiers changed from: protected */
    public n g(n nVar, d dVar, boolean z10) {
        m.f(nVar, "consumer");
        m.f(dVar, "cacheKey");
        return nVar;
    }
}
