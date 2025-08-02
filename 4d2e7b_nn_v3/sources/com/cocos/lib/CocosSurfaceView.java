package com.cocos.lib;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CocosSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    private long mNativeHandle;
    private CocosTouchHandler mTouchHandler = new CocosTouchHandler(this.mWindowId);
    /* access modifiers changed from: private */
    public int mWindowId;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19292b;

        a(int i10, int i11) {
            this.f19291a = i10;
            this.f19292b = i11;
        }

        public void run() {
            CocosSurfaceView cocosSurfaceView = CocosSurfaceView.this;
            cocosSurfaceView.onSizeChangedNative(cocosSurfaceView.mWindowId, this.f19291a, this.f19292b);
        }
    }

    public CocosSurfaceView(Context context, int i10) {
        super(context);
        this.mWindowId = i10;
        this.mNativeHandle = constructNative(i10);
        getHolder().addCallback(this);
    }

    private native long constructNative(int i10);

    private native void destructNative(long j10);

    /* access modifiers changed from: private */
    public native void onSizeChangedNative(int i10, int i11, int i12);

    private native void onSurfaceChangedNative(long j10, Surface surface, int i10, int i11, int i12);

    private native void onSurfaceCreatedNative(long j10, Surface surface);

    private native void onSurfaceDestroyedNative(long j10);

    private native void onSurfaceRedrawNeededNative(long j10);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        destructNative(this.mNativeHandle);
        this.mNativeHandle = 0;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        CocosHelper.runOnGameThreadAtForeground(new a(i10, i11));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mTouchHandler.onTouchEvent(motionEvent);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        onSurfaceChangedNative(this.mNativeHandle, surfaceHolder.getSurface(), i10, i11, i12);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        onSurfaceCreatedNative(this.mNativeHandle, surfaceHolder.getSurface());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        onSurfaceDestroyedNative(this.mNativeHandle);
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        onSurfaceRedrawNeededNative(this.mNativeHandle);
    }
}
