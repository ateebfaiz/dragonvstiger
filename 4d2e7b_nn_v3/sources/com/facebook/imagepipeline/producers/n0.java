package com.facebook.imagepipeline.producers;

import b3.i;
import e5.j;
import java.io.FileInputStream;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class n0 extends m0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20179c = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(Executor executor, i iVar) {
        super(executor, iVar);
        m.f(executor, "executor");
        m.f(iVar, "pooledByteBufferFactory");
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        m.f(bVar, "imageRequest");
        return d(new FileInputStream(bVar.t().toString()), (int) bVar.t().length());
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "LocalFileFetchProducer";
    }
}
