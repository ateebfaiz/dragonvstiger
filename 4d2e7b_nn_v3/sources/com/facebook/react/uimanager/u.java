package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.q;
import com.facebook.react.uimanager.events.r;
import com.facebook.react.uimanager.events.s;
import z2.a;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private int f3925a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f3926b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    private boolean f3927c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f3928d = Long.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f3929e;

    /* renamed from: f  reason: collision with root package name */
    private final r f3930f = new r();

    public u(ViewGroup viewGroup) {
        this.f3929e = viewGroup;
    }

    private void a(MotionEvent motionEvent, e eVar) {
        if (this.f3925a == -1) {
            a.G("ReactNative", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        p5.a.b(!this.f3927c, "Expected to not have already sent a cancel for this gesture");
        int f10 = k1.f(this.f3929e);
        int i10 = this.f3925a;
        s sVar = s.CANCEL;
        long j10 = this.f3928d;
        float[] fArr = this.f3926b;
        ((e) p5.a.c(eVar)).c(q.h(f10, i10, sVar, motionEvent, j10, fArr[0], fArr[1], this.f3930f));
    }

    private int b(MotionEvent motionEvent) {
        return f1.c(motionEvent.getX(), motionEvent.getY(), this.f3929e, this.f3926b, (int[]) null);
    }

    public void c(MotionEvent motionEvent, e eVar) {
        e eVar2 = eVar;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.f3925a != -1) {
                a.j("ReactNative", "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.f3927c = false;
            this.f3928d = motionEvent.getEventTime();
            this.f3925a = b(motionEvent);
            int f10 = k1.f(this.f3929e);
            int i10 = this.f3925a;
            s sVar = s.START;
            long j10 = this.f3928d;
            float[] fArr = this.f3926b;
            eVar2.c(q.h(f10, i10, sVar, motionEvent, j10, fArr[0], fArr[1], this.f3930f));
        } else if (!this.f3927c) {
            if (this.f3925a == -1) {
                a.j("ReactNative", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            } else if (action == 1) {
                b(motionEvent);
                int f11 = k1.f(this.f3929e);
                int i11 = this.f3925a;
                s sVar2 = s.END;
                long j11 = this.f3928d;
                float[] fArr2 = this.f3926b;
                eVar2.c(q.h(f11, i11, sVar2, motionEvent, j11, fArr2[0], fArr2[1], this.f3930f));
                this.f3925a = -1;
                this.f3928d = Long.MIN_VALUE;
            } else if (action == 2) {
                b(motionEvent);
                int f12 = k1.f(this.f3929e);
                int i12 = this.f3925a;
                s sVar3 = s.MOVE;
                long j12 = this.f3928d;
                float[] fArr3 = this.f3926b;
                eVar2.c(q.h(f12, i12, sVar3, motionEvent, j12, fArr3[0], fArr3[1], this.f3930f));
            } else if (action == 5) {
                int f13 = k1.f(this.f3929e);
                int i13 = this.f3925a;
                s sVar4 = s.START;
                long j13 = this.f3928d;
                float[] fArr4 = this.f3926b;
                eVar2.c(q.h(f13, i13, sVar4, motionEvent, j13, fArr4[0], fArr4[1], this.f3930f));
            } else if (action == 6) {
                int f14 = k1.f(this.f3929e);
                int i14 = this.f3925a;
                s sVar5 = s.END;
                long j14 = this.f3928d;
                float[] fArr5 = this.f3926b;
                eVar2.c(q.h(f14, i14, sVar5, motionEvent, j14, fArr5[0], fArr5[1], this.f3930f));
            } else if (action == 3) {
                if (this.f3930f.c(motionEvent.getDownTime())) {
                    a(motionEvent, eVar);
                } else {
                    a.j("ReactNative", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
                }
                this.f3925a = -1;
                this.f3928d = Long.MIN_VALUE;
            } else {
                a.G("ReactNative", "Warning : touch event was ignored. Action=" + action + " Target=" + this.f3925a);
            }
        }
    }

    public void d(MotionEvent motionEvent, e eVar) {
        this.f3927c = false;
    }

    public void e(MotionEvent motionEvent, e eVar) {
        if (!this.f3927c) {
            a(motionEvent, eVar);
            this.f3927c = true;
            this.f3925a = -1;
        }
    }
}
