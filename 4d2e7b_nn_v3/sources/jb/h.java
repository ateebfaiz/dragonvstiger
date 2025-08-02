package jb;

import android.view.MotionEvent;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private float f12456a;

    /* renamed from: b  reason: collision with root package name */
    private float f12457b;

    /* renamed from: c  reason: collision with root package name */
    private float f12458c;

    /* renamed from: d  reason: collision with root package name */
    private float f12459d;

    /* renamed from: e  reason: collision with root package name */
    private int f12460e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f12461f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f12462g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12463h;

    /* renamed from: i  reason: collision with root package name */
    private a f12464i;

    public interface a {
        boolean a(h hVar);
    }

    public static class b implements a {
    }

    public h(a aVar) {
        this.f12464i = aVar;
    }

    private float a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b((float) Math.toDegrees((double) ((float) Math.atan2((double) (f11 - f13), (double) (f10 - f12)))), (float) Math.toDegrees((double) ((float) Math.atan2((double) (f15 - f17), (double) (f14 - f16)))));
    }

    private float b(float f10, float f11) {
        float f12 = (f11 % 360.0f) - (f10 % 360.0f);
        this.f12462g = f12;
        if (f12 < -180.0f) {
            this.f12462g = f12 + 360.0f;
        } else if (f12 > 180.0f) {
            this.f12462g = f12 - 360.0f;
        }
        return this.f12462g;
    }

    public float c() {
        return this.f12462g;
    }

    public boolean d(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f12458c = motionEvent.getX();
            this.f12459d = motionEvent.getY();
            this.f12460e = motionEvent2.findPointerIndex(motionEvent2.getPointerId(0));
            this.f12462g = 0.0f;
            this.f12463h = true;
        } else if (actionMasked == 1) {
            this.f12460e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f12456a = motionEvent.getX();
                this.f12457b = motionEvent.getY();
                this.f12461f = motionEvent2.findPointerIndex(motionEvent2.getPointerId(motionEvent.getActionIndex()));
                this.f12462g = 0.0f;
                this.f12463h = true;
            } else if (actionMasked == 6) {
                this.f12461f = -1;
            }
        } else if (!(this.f12460e == -1 || this.f12461f == -1 || motionEvent.getPointerCount() <= this.f12461f)) {
            float x10 = motionEvent2.getX(this.f12460e);
            float y10 = motionEvent2.getY(this.f12460e);
            float x11 = motionEvent2.getX(this.f12461f);
            float y11 = motionEvent2.getY(this.f12461f);
            if (this.f12463h) {
                this.f12462g = 0.0f;
                this.f12463h = false;
            } else {
                a(this.f12456a, this.f12457b, this.f12458c, this.f12459d, x11, y11, x10, y10);
            }
            a aVar = this.f12464i;
            if (aVar != null) {
                aVar.a(this);
            }
            this.f12456a = x11;
            this.f12457b = y11;
            this.f12458c = x10;
            this.f12459d = y10;
        }
        return true;
    }
}
