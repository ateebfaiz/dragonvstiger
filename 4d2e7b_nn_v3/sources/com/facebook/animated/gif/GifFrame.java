package com.facebook.animated.gif;

import android.graphics.Bitmap;
import r4.d;

public class GifFrame implements d {
    @y2.d
    private long mNativeContext;

    @y2.d
    GifFrame(long j10) {
        this.mNativeContext = j10;
    }

    @y2.d
    private native void nativeDispose();

    @y2.d
    private native void nativeFinalize();

    @y2.d
    private native int nativeGetDisposalMode();

    @y2.d
    private native int nativeGetDurationMs();

    @y2.d
    private native int nativeGetHeight();

    @y2.d
    private native int nativeGetTransparentPixelColor();

    @y2.d
    private native int nativeGetWidth();

    @y2.d
    private native int nativeGetXOffset();

    @y2.d
    private native int nativeGetYOffset();

    @y2.d
    private native boolean nativeHasTransparency();

    @y2.d
    private native void nativeRenderFrame(int i10, int i11, Bitmap bitmap);

    public void a(int i10, int i11, Bitmap bitmap) {
        nativeRenderFrame(i10, i11, bitmap);
    }

    public int b() {
        return nativeGetXOffset();
    }

    public int c() {
        return nativeGetYOffset();
    }

    public int d() {
        return nativeGetDisposalMode();
    }

    public void dispose() {
        nativeDispose();
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
