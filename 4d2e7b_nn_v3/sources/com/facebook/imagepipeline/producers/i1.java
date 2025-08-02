package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import b3.i;
import e5.j;
import java.io.InputStream;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class i1 extends m0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20117d = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f20118c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i1(Executor executor, i iVar, ContentResolver contentResolver) {
        super(executor, iVar);
        m.f(executor, "executor");
        m.f(iVar, "pooledByteBufferFactory");
        m.f(contentResolver, "contentResolver");
        this.f20118c = contentResolver;
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        m.f(bVar, "imageRequest");
        InputStream openInputStream = this.f20118c.openInputStream(bVar.u());
        if (openInputStream != null) {
            j d10 = d(openInputStream, -1);
            m.e(d10, "getEncodedImage(\n       …mage.UNKNOWN_STREAM_SIZE)");
            return d10;
        }
        throw new IllegalStateException("ContentResolver returned null InputStream".toString());
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "QualifiedResourceFetchProducer";
    }
}
