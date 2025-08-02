package e4;

import c4.b;
import e4.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int f21242a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f21243b = d.class;

    public d(int i10) {
        this.f21242a = i10;
    }

    public void a(int i10, int i11, Function0 function0) {
        a.C0267a.d(this, i10, i11, function0);
    }

    public c3.a b(int i10, int i11, int i12) {
        return a.C0267a.b(this, i10, i11, i12);
    }

    public void c() {
        a.C0267a.a(this);
    }

    public void d(b bVar, b bVar2, b4.a aVar, int i10, Function0 function0) {
        m.f(bVar, "bitmapFramePreparer");
        m.f(bVar2, "bitmapFrameCache");
        m.f(aVar, "animationBackend");
        int i11 = this.f21242a;
        int i12 = 1;
        if (1 <= i11) {
            while (true) {
                int frameCount = (i10 + i12) % aVar.getFrameCount();
                if (z2.a.u(2)) {
                    z2.a.x(this.f21243b, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i10));
                }
                if (bVar.a(bVar2, aVar, frameCount)) {
                    if (i12 == i11) {
                        break;
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onStop() {
        a.C0267a.c(this);
    }
}
