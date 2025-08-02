package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import b3.i;
import e5.j;
import java.io.IOException;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class o0 extends m0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20182d = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final Resources f20183c;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final int b(b bVar) {
            String path = bVar.u().getPath();
            if (path != null) {
                String substring = path.substring(1);
                m.e(substring, "this as java.lang.String).substring(startIndex)");
                return Integer.parseInt(substring);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(Executor executor, i iVar, Resources resources) {
        super(executor, iVar);
        m.f(executor, "executor");
        m.f(iVar, "pooledByteBufferFactory");
        m.f(resources, "resources");
        this.f20183c = resources;
    }

    private final int g(b bVar) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openRawResourceFd = this.f20183c.openRawResourceFd(f20182d.b(bVar));
            int length = (int) openRawResourceFd.getLength();
            try {
                openRawResourceFd.close();
                return length;
            } catch (IOException unused) {
                return length;
            }
        } catch (Resources.NotFoundException unused2) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        m.f(bVar, "imageRequest");
        return d(this.f20183c.openRawResource(f20182d.b(bVar)), g(bVar));
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "LocalResourceFetchProducer";
    }
}
