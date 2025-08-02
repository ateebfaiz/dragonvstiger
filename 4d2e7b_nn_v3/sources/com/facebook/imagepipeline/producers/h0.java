package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import b3.i;
import e5.j;
import java.io.IOException;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h0 extends m0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20106d = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final AssetManager f20107c;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String b(b bVar) {
            String path = bVar.u().getPath();
            m.c(path);
            String substring = path.substring(1);
            m.e(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(Executor executor, i iVar, AssetManager assetManager) {
        super(executor, iVar);
        m.f(executor, "executor");
        m.f(iVar, "pooledByteBufferFactory");
        m.f(assetManager, "assetManager");
        this.f20107c = assetManager;
    }

    private final int g(b bVar) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openFd = this.f20107c.openFd(f20106d.b(bVar));
            int length = (int) openFd.getLength();
            try {
                openFd.close();
                return length;
            } catch (IOException unused) {
                return length;
            }
        } catch (IOException unused2) {
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
        return d(this.f20107c.open(f20106d.b(bVar), 2), g(bVar));
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "LocalAssetFetchProducer";
    }
}
