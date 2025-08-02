package g4;

import kotlin.jvm.internal.m;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final c3.a f21728a;

    /* renamed from: b  reason: collision with root package name */
    private final a f21729b;

    public enum a {
        SUCCESS,
        NEAREST,
        MISSING
    }

    public k(c3.a aVar, a aVar2) {
        m.f(aVar2, "type");
        this.f21728a = aVar;
        this.f21729b = aVar2;
    }

    public final c3.a a() {
        return this.f21728a;
    }

    public final a b() {
        return this.f21729b;
    }
}
