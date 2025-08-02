package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.events.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

public final class q extends d {

    /* renamed from: f  reason: collision with root package name */
    public static final a f3649f = new a((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final String f3650g = q.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Pools.SynchronizedPool f3651h = new Pools.SynchronizedPool(3);

    /* renamed from: a  reason: collision with root package name */
    private MotionEvent f3652a;

    /* renamed from: b  reason: collision with root package name */
    private s f3653b;

    /* renamed from: c  reason: collision with root package name */
    private short f3654c;

    /* renamed from: d  reason: collision with root package name */
    private float f3655d;

    /* renamed from: e  reason: collision with root package name */
    private float f3656e;

    public static final class a {
        private a() {
        }

        public final q a(int i10, int i11, s sVar, MotionEvent motionEvent, long j10, float f10, float f11, r rVar) {
            m.f(rVar, "touchEventCoalescingKeyHelper");
            q qVar = (q) q.f3651h.acquire();
            if (qVar == null) {
                qVar = new q((DefaultConstructorMarker) null);
            }
            Object c10 = p5.a.c(motionEvent);
            m.e(c10, "assertNotNull(...)");
            qVar.g(i10, i11, sVar, (MotionEvent) c10, j10, f10, f11, rVar);
            return qVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3657a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.facebook.react.uimanager.events.s[] r0 = com.facebook.react.uimanager.events.s.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.uimanager.events.s r1 = com.facebook.react.uimanager.events.s.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.facebook.react.uimanager.events.s r1 = com.facebook.react.uimanager.events.s.END     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.facebook.react.uimanager.events.s r1 = com.facebook.react.uimanager.events.s.CANCEL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.facebook.react.uimanager.events.s r1 = com.facebook.react.uimanager.events.s.MOVE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f3657a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.q.b.<clinit>():void");
        }
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final void g(int i10, int i11, s sVar, MotionEvent motionEvent, long j10, float f10, float f11, r rVar) {
        boolean z10;
        super.init(i10, i11, motionEvent.getEventTime());
        short s10 = 0;
        if (j10 != Long.MIN_VALUE) {
            z10 = true;
        } else {
            z10 = false;
        }
        SoftAssertions.assertCondition(z10, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            rVar.a(j10);
        } else if (action == 1) {
            rVar.e(j10);
        } else if (action == 2) {
            s10 = rVar.b(j10);
        } else if (action == 3) {
            rVar.e(j10);
        } else if (action == 5 || action == 6) {
            rVar.d(j10);
        } else {
            throw new RuntimeException("Unhandled MotionEvent action: " + action);
        }
        this.f3652a = MotionEvent.obtain(motionEvent);
        this.f3653b = sVar;
        this.f3654c = s10;
        this.f3655d = f10;
        this.f3656e = f11;
    }

    public static final q h(int i10, int i11, s sVar, MotionEvent motionEvent, long j10, float f10, float f11, r rVar) {
        return f3649f.a(i10, i11, sVar, motionEvent, j10, f10, f11, rVar);
    }

    private final boolean i() {
        if (this.f3652a != null) {
            return true;
        }
        ReactSoftExceptionLogger.logSoftException(f3650g, new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        return false;
    }

    public final MotionEvent c() {
        Object c10 = p5.a.c(this.f3652a);
        m.e(c10, "assertNotNull(...)");
        return (MotionEvent) c10;
    }

    public boolean canCoalesce() {
        int i10;
        s sVar = (s) p5.a.c(this.f3653b);
        if (sVar == null) {
            i10 = -1;
        } else {
            i10 = b.f3657a[sVar.ordinal()];
        }
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return false;
        }
        if (i10 == 4) {
            return true;
        }
        s sVar2 = this.f3653b;
        throw new RuntimeException("Unknown touch event type: " + sVar2);
    }

    public final s d() {
        Object c10 = p5.a.c(this.f3653b);
        m.e(c10, "assertNotNull(...)");
        return (s) c10;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        m.f(rCTEventEmitter, "rctEventEmitter");
        if (i()) {
            t.d(rCTEventEmitter, this);
        }
    }

    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        m.f(rCTModernEventEmitter, "rctEventEmitter");
        if (i()) {
            rCTModernEventEmitter.receiveTouches(this);
        }
    }

    public final float e() {
        return this.f3655d;
    }

    public final float f() {
        return this.f3656e;
    }

    public short getCoalescingKey() {
        return this.f3654c;
    }

    /* access modifiers changed from: protected */
    public int getEventCategory() {
        s sVar = this.f3653b;
        if (sVar == null) {
            return 2;
        }
        int i10 = b.f3657a[sVar.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2 || i10 == 3) {
            return 1;
        }
        if (i10 == 4) {
            return 4;
        }
        throw new n();
    }

    public String getEventName() {
        s.a aVar = s.f3659b;
        Object c10 = p5.a.c(this.f3653b);
        m.e(c10, "assertNotNull(...)");
        return aVar.a((s) c10);
    }

    public void onDispose() {
        MotionEvent motionEvent = this.f3652a;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.f3652a = null;
        try {
            f3651h.release(this);
        } catch (IllegalStateException e10) {
            ReactSoftExceptionLogger.logSoftException(f3650g, e10);
        }
    }

    private q() {
    }
}
