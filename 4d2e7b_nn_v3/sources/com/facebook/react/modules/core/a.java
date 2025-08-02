package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayDeque;
import n6.b;
import w6.i;
import w6.j;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static a f3234f;

    /* renamed from: a  reason: collision with root package name */
    private b.a f3235a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque[] f3236b;

    /* renamed from: c  reason: collision with root package name */
    private final Choreographer.FrameCallback f3237c = new C0052a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f3238d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f3239e;

    /* renamed from: com.facebook.react.modules.core.a$a  reason: collision with other inner class name */
    class C0052a implements Choreographer.FrameCallback {
        C0052a() {
        }

        public void doFrame(long j10) {
            synchronized (a.this.f3236b) {
                try {
                    a.this.f3239e = false;
                    for (ArrayDeque arrayDeque : a.this.f3236b) {
                        int size = arrayDeque.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Choreographer.FrameCallback frameCallback = (Choreographer.FrameCallback) arrayDeque.pollFirst();
                            if (frameCallback != null) {
                                frameCallback.doFrame(j10);
                                a aVar = a.this;
                                aVar.f3238d = aVar.f3238d - 1;
                            } else {
                                z2.a.j("ReactNative", "Tried to execute non-existent frame callback");
                            }
                        }
                    }
                    a.this.l();
                } finally {
                }
            }
        }
    }

    public enum b {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3247a;

        private b(int i10) {
            this.f3247a = i10;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f3247a;
        }
    }

    private a(n6.b bVar) {
        int i10 = 0;
        this.f3238d = 0;
        this.f3239e = false;
        this.f3236b = new ArrayDeque[b.values().length];
        while (true) {
            ArrayDeque[] arrayDequeArr = this.f3236b;
            if (i10 < arrayDequeArr.length) {
                arrayDequeArr[i10] = new ArrayDeque();
                i10++;
            } else {
                UiThreadUtil.runOnUiThread(new j(this, bVar));
                return;
            }
        }
    }

    public static a h() {
        p5.a.d(f3234f, "ReactChoreographer needs to be initialized.");
        return f3234f;
    }

    public static void i(n6.b bVar) {
        if (f3234f == null) {
            f3234f = new a(bVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(n6.b bVar) {
        this.f3235a = bVar.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        synchronized (this.f3236b) {
            n();
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        boolean z10;
        if (this.f3238d >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.a(z10);
        if (this.f3238d == 0 && this.f3239e) {
            b.a aVar = this.f3235a;
            if (aVar != null) {
                aVar.b(this.f3237c);
            }
            this.f3239e = false;
        }
    }

    private void n() {
        this.f3235a.a(this.f3237c);
        this.f3239e = true;
    }

    public void m(b bVar, Choreographer.FrameCallback frameCallback) {
        synchronized (this.f3236b) {
            try {
                this.f3236b[bVar.b()].addLast(frameCallback);
                boolean z10 = true;
                int i10 = this.f3238d + 1;
                this.f3238d = i10;
                if (i10 <= 0) {
                    z10 = false;
                }
                p5.a.a(z10);
                if (!this.f3239e) {
                    if (this.f3235a == null) {
                        UiThreadUtil.runOnUiThread(new i(this));
                    } else {
                        n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(b bVar, Choreographer.FrameCallback frameCallback) {
        synchronized (this.f3236b) {
            try {
                if (this.f3236b[bVar.b()].removeFirstOccurrence(frameCallback)) {
                    this.f3238d--;
                    l();
                } else {
                    z2.a.j("ReactNative", "Tried to remove non-existent frame callback");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
