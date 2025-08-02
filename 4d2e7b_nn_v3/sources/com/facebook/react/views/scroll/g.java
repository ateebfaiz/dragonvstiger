package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;

class g {

    /* renamed from: a  reason: collision with root package name */
    private VelocityTracker f4176a;

    /* renamed from: b  reason: collision with root package name */
    private float f4177b;

    /* renamed from: c  reason: collision with root package name */
    private float f4178c;

    g() {
    }

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f4176a == null) {
            this.f4176a = VelocityTracker.obtain();
        }
        this.f4176a.addMovement(motionEvent);
        if (action == 1 || action == 3) {
            this.f4176a.computeCurrentVelocity(1);
            this.f4177b = this.f4176a.getXVelocity();
            this.f4178c = this.f4176a.getYVelocity();
            VelocityTracker velocityTracker = this.f4176a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4176a = null;
            }
        }
    }

    public float b() {
        return this.f4177b;
    }

    public float c() {
        return this.f4178c;
    }
}
