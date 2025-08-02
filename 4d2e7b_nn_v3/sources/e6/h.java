package e6;

import kotlin.jvm.internal.m;
import p5.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private Thread f11919a;

    public final void a() {
        Thread currentThread = Thread.currentThread();
        if (this.f11919a == null) {
            this.f11919a = currentThread;
        }
        a.a(m.b(this.f11919a, currentThread));
    }
}
