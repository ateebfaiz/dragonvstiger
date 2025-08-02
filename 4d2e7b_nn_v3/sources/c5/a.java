package c5;

import e5.j;
import kotlin.jvm.internal.m;

public final class a extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final j f17314a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, j jVar) {
        super(str);
        m.f(jVar, "encodedImage");
        this.f17314a = jVar;
    }

    public final j a() {
        return this.f17314a;
    }
}
