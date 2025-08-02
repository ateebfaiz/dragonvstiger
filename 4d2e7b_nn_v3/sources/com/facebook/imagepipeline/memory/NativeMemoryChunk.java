package com.facebook.imagepipeline.memory;

import a8.a;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import h5.v;
import h5.w;
import java.io.Closeable;
import java.nio.ByteBuffer;
import y2.d;
import y2.l;

@d
public class NativeMemoryChunk implements v, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final long f19960a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19961b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19962c;

    static {
        a.d("imagepipeline");
    }

    public NativeMemoryChunk(int i10) {
        l.b(Boolean.valueOf(i10 > 0));
        this.f19961b = i10;
        this.f19960a = nativeAllocate(i10);
        this.f19962c = false;
    }

    private void j(int i10, v vVar, int i11, int i12) {
        if (vVar instanceof NativeMemoryChunk) {
            l.i(!isClosed());
            l.i(!vVar.isClosed());
            w.b(i10, vVar.getSize(), i11, i12, this.f19961b);
            nativeMemcpy(vVar.f() + ((long) i11), this.f19960a + ((long) i10), i12);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @d
    private static native long nativeAllocate(int i10);

    @d
    private static native void nativeCopyFromByteArray(long j10, byte[] bArr, int i10, int i11);

    @d
    private static native void nativeCopyToByteArray(long j10, byte[] bArr, int i10, int i11);

    @d
    private static native void nativeFree(long j10);

    @d
    private static native void nativeMemcpy(long j10, long j11, int i10);

    @d
    private static native byte nativeReadByte(long j10);

    public long a() {
        return this.f19960a;
    }

    public synchronized int b(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.i(!isClosed());
        a10 = w.a(i10, i12, this.f19961b);
        w.b(i10, bArr.length, i11, a10, this.f19961b);
        nativeCopyFromByteArray(this.f19960a + ((long) i10), bArr, i11, a10);
        return a10;
    }

    public synchronized byte c(int i10) {
        boolean z10;
        boolean z11 = false;
        l.i(!isClosed());
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 < this.f19961b) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        return nativeReadByte(this.f19960a + ((long) i10));
    }

    public synchronized void close() {
        if (!this.f19962c) {
            this.f19962c = true;
            nativeFree(this.f19960a);
        }
    }

    public synchronized int d(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.i(!isClosed());
        a10 = w.a(i10, i12, this.f19961b);
        w.b(i10, bArr.length, i11, a10, this.f19961b);
        nativeCopyToByteArray(this.f19960a + ((long) i10), bArr, i11, a10);
        return a10;
    }

    public ByteBuffer e() {
        return null;
    }

    public long f() {
        return this.f19960a;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!isClosed()) {
            Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public int getSize() {
        return this.f19961b;
    }

    public void h(int i10, v vVar, int i11, int i12) {
        l.g(vVar);
        if (vVar.a() == a()) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(vVar)) + " which share the same address " + Long.toHexString(this.f19960a));
            l.b(Boolean.FALSE);
        }
        if (vVar.a() < a()) {
            synchronized (vVar) {
                synchronized (this) {
                    j(i10, vVar, i11, i12);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (vVar) {
                j(i10, vVar, i11, i12);
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.f19962c;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f19961b = 0;
        this.f19960a = 0;
        this.f19962c = true;
    }
}
