package x8;

import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import u8.c;
import u8.d;
import y8.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f13236a = new b();

    private b() {
    }

    public final d a(Class cls, Object[] objArr, Object obj, boolean z10, Method method, i iVar, c cVar) {
        m.f(cls, "targetClass");
        m.f(method, "targetMethod");
        c cVar2 = cVar;
        m.f(cVar2, "aopMethod");
        return new d(cls, objArr, obj, z10, method, iVar, cVar2);
    }

    public final d b(Class cls, Object[] objArr, Object obj, boolean z10, Method method, i iVar, c cVar) {
        m.f(cls, "targetClass");
        m.f(method, "targetMethod");
        c cVar2 = cVar;
        m.f(cVar2, "aopMethod");
        return new e(cls, objArr, obj, z10, method, iVar, cVar2);
    }

    public final void c(d dVar, boolean z10) {
        m.f(dVar, "proceedJoinPoint");
        ((d) dVar).f(z10);
    }

    public final void d(d dVar, c cVar) {
        m.f(dVar, "proceedJoinPoint");
        m.f(cVar, "onInvokeListener");
        ((d) dVar).g(cVar);
    }

    public final void e(d dVar, Method method) {
        m.f(dVar, "proceedJoinPoint");
        ((d) dVar).i(method);
    }
}
