package x4;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import r2.d;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f24773a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f24774b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f24775c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f24776d;

    public /* synthetic */ e(Object obj, AtomicBoolean atomicBoolean, j jVar, d dVar) {
        this.f24773a = obj;
        this.f24774b = atomicBoolean;
        this.f24775c = jVar;
        this.f24776d = dVar;
    }

    public final Object call() {
        return j.o(this.f24773a, this.f24774b, this.f24775c, this.f24776d);
    }
}
