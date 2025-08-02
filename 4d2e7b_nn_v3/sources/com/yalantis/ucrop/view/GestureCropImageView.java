package com.yalantis.ucrop.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import jb.h;

public class GestureCropImageView extends CropImageView {

    /* renamed from: c1  reason: collision with root package name */
    private ScaleGestureDetector f11802c1;

    /* renamed from: d1  reason: collision with root package name */
    private h f11803d1;

    /* renamed from: e1  reason: collision with root package name */
    private GestureDetector f11804e1;
    /* access modifiers changed from: private */

    /* renamed from: f1  reason: collision with root package name */
    public float f11805f1;
    /* access modifiers changed from: private */

    /* renamed from: g1  reason: collision with root package name */
    public float f11806g1;

    /* renamed from: h1  reason: collision with root package name */
    private boolean f11807h1;

    /* renamed from: i1  reason: collision with root package name */
    private boolean f11808i1;

    /* renamed from: j1  reason: collision with root package name */
    private int f11809j1;

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.z(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200);
            return super.onDoubleTap(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            GestureCropImageView.this.k(-f10, -f11);
            return true;
        }
    }

    private class c extends h.b {
        private c() {
        }

        public boolean a(h hVar) {
            GestureCropImageView.this.i(hVar.c(), GestureCropImageView.this.f11805f1, GestureCropImageView.this.f11806g1);
            return true;
        }
    }

    private class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.j(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.f11805f1, GestureCropImageView.this.f11806g1);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void G() {
        this.f11804e1 = new GestureDetector(getContext(), new b(), (Handler) null, true);
        this.f11802c1 = new ScaleGestureDetector(getContext(), new d());
        this.f11803d1 = new h(new c());
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        G();
    }

    public int getDoubleTapScaleSteps() {
        return this.f11809j1;
    }

    /* access modifiers changed from: protected */
    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.f11809j1))));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            r();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f11805f1 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.f11806g1 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.f11804e1.onTouchEvent(motionEvent);
        if (this.f11808i1) {
            this.f11802c1.onTouchEvent(motionEvent);
        }
        if (this.f11807h1) {
            this.f11803d1.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            x();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i10) {
        this.f11809j1 = i10;
    }

    public void setRotateEnabled(boolean z10) {
        this.f11807h1 = z10;
    }

    public void setScaleEnabled(boolean z10) {
        this.f11808i1 = z10;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11807h1 = true;
        this.f11808i1 = true;
        this.f11809j1 = 5;
    }
}
