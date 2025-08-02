package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.e;
import java.nio.ByteBuffer;
import r4.b;
import r4.c;
import y2.d;
import y2.l;

@d
public class WebPImage implements c, s4.c {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap.Config f19587a = null;
    @d
    private long mNativeContext;

    @d
    public WebPImage() {
    }

    public static WebPImage i(ByteBuffer byteBuffer, y4.c cVar) {
        e.a();
        byteBuffer.rewind();
        WebPImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (cVar != null) {
            nativeCreateFromDirectByteBuffer.f19587a = cVar.f24904i;
        }
        return nativeCreateFromDirectByteBuffer;
    }

    public static WebPImage j(long j10, int i10, y4.c cVar) {
        boolean z10;
        e.a();
        if (j10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        WebPImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j10, i10);
        if (cVar != null) {
            nativeCreateFromNativeMemory.f19587a = cVar.f24904i;
        }
        return nativeCreateFromNativeMemory;
    }

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j10, int i10);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i10);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public b a(int i10) {
        b.a aVar;
        b.C0328b bVar;
        WebPFrame k10 = e(i10);
        try {
            int b10 = k10.b();
            int c10 = k10.c();
            int width = k10.getWidth();
            int height = k10.getHeight();
            if (k10.d()) {
                aVar = b.a.BLEND_WITH_PREVIOUS;
            } else {
                aVar = b.a.NO_BLEND;
            }
            b.a aVar2 = aVar;
            if (k10.e()) {
                bVar = b.C0328b.DISPOSE_TO_BACKGROUND;
            } else {
                bVar = b.C0328b.DISPOSE_DO_NOT;
            }
            b bVar2 = new b(i10, b10, c10, width, height, aVar2, bVar);
            k10.dispose();
            return bVar2;
        } catch (Throwable th) {
            k10.dispose();
            throw th;
        }
    }

    public c b(long j10, int i10, y4.c cVar) {
        return j(j10, i10, cVar);
    }

    public c c(ByteBuffer byteBuffer, y4.c cVar) {
        return i(byteBuffer, cVar);
    }

    public Bitmap.Config d() {
        return this.f19587a;
    }

    public boolean f() {
        return true;
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
        return nativeGetLoopCount();
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    public int[] h() {
        return nativeGetFrameDurations();
    }

    /* renamed from: k */
    public WebPFrame e(int i10) {
        return nativeGetFrame(i10);
    }

    @d
    WebPImage(long j10) {
        this.mNativeContext = j10;
    }
}
