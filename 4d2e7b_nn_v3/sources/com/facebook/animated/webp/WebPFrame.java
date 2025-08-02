package com.facebook.animated.webp;

import android.graphics.Bitmap;
import r4.d;

public class WebPFrame implements d {
    @y2.d
    private long mNativeContext;

    @y2.d
    WebPFrame(long j10) {
        this.mNativeContext = j10;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i10, int i11, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

    public void a(int i10, int i11, Bitmap bitmap) {
        nativeRenderFrame(i10, i11, bitmap);
    }

    public int b() {
        return nativeGetXOffset();
    }

    public int c() {
        return nativeGetYOffset();
    }

    public boolean d() {
        return nativeIsBlendWithPreviousFrame();
    }

    public void dispose() {
        nativeDispose();
    }

    public boolean e() {
        return nativeShouldDisposeToBackgroundColor();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getWidth() {
        return nativeGetWidth();
    }
}
