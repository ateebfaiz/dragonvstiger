package com.facebook.animated.gif;

import a8.a;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import r4.b;
import r4.c;
import y2.d;
import y2.l;

@d
public class GifImage implements c, s4.c {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f19585b;

    /* renamed from: a  reason: collision with root package name */
    private Bitmap.Config f19586a = null;
    @d
    private long mNativeContext;

    @d
    public GifImage() {
    }

    public static GifImage i(ByteBuffer byteBuffer, y4.c cVar) {
        k();
        byteBuffer.rewind();
        GifImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, cVar.f24897b, cVar.f24902g);
        nativeCreateFromDirectByteBuffer.f19586a = cVar.f24904i;
        return nativeCreateFromDirectByteBuffer;
    }

    public static GifImage j(long j10, int i10, y4.c cVar) {
        boolean z10;
        k();
        if (j10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        GifImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j10, i10, cVar.f24897b, cVar.f24902g);
        nativeCreateFromNativeMemory.f19586a = cVar.f24904i;
        return nativeCreateFromNativeMemory;
    }

    private static synchronized void k() {
        synchronized (GifImage.class) {
            if (!f19585b) {
                f19585b = true;
                a.d("gifimage");
            }
        }
    }

    private static b.C0328b l(int i10) {
        if (i10 == 0) {
            return b.C0328b.DISPOSE_DO_NOT;
        }
        if (i10 == 1) {
            return b.C0328b.DISPOSE_DO_NOT;
        }
        if (i10 == 2) {
            return b.C0328b.DISPOSE_TO_BACKGROUND;
        }
        if (i10 == 3) {
            return b.C0328b.DISPOSE_TO_PREVIOUS;
        }
        return b.C0328b.DISPOSE_DO_NOT;
    }

    @d
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i10, boolean z10);

    @d
    private static native GifImage nativeCreateFromFileDescriptor(int i10, int i11, boolean z10);

    @d
    private static native GifImage nativeCreateFromNativeMemory(long j10, int i10, int i11, boolean z10);

    @d
    private native void nativeDispose();

    @d
    private native void nativeFinalize();

    @d
    private native int nativeGetDuration();

    @d
    private native GifFrame nativeGetFrame(int i10);

    @d
    private native int nativeGetFrameCount();

    @d
    private native int[] nativeGetFrameDurations();

    @d
    private native int nativeGetHeight();

    @d
    private native int nativeGetLoopCount();

    @d
    private native int nativeGetSizeInBytes();

    @d
    private native int nativeGetWidth();

    @d
    private native boolean nativeIsAnimated();

    public b a(int i10) {
        GifFrame m10 = e(i10);
        try {
            return new b(i10, m10.b(), m10.c(), m10.getWidth(), m10.getHeight(), b.a.BLEND_WITH_PREVIOUS, l(m10.d()));
        } finally {
            m10.dispose();
        }
    }

    public c b(long j10, int i10, y4.c cVar) {
        return j(j10, i10, cVar);
    }

    public c c(ByteBuffer byteBuffer, y4.c cVar) {
        return i(byteBuffer, cVar);
    }

    public Bitmap.Config d() {
        return this.f19586a;
    }

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public int g() {
        return nativeGetSizeInBytes();
    }

    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount == -1) {
            return 1;
        }
        if (nativeGetLoopCount != 0) {
            return nativeGetLoopCount + 1;
        }
        return 0;
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    public int[] h() {
        return nativeGetFrameDurations();
    }

    /* renamed from: m */
    public GifFrame e(int i10) {
        return nativeGetFrame(i10);
    }

    @d
    GifImage(long j10) {
        this.mNativeContext = j10;
    }
}
