package cc;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.v1;

final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f86a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f87b;

    /* renamed from: c  reason: collision with root package name */
    private final v1[] f88c;

    /* renamed from: d  reason: collision with root package name */
    private int f89d;

    public k0(CoroutineContext coroutineContext, int i10) {
        this.f86a = coroutineContext;
        this.f87b = new Object[i10];
        this.f88c = new v1[i10];
    }

    public final void a(v1 v1Var, Object obj) {
        Object[] objArr = this.f87b;
        int i10 = this.f89d;
        objArr[i10] = obj;
        v1[] v1VarArr = this.f88c;
        this.f89d = i10 + 1;
        m.d(v1Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        v1VarArr[i10] = v1Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f88c.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                v1 v1Var = this.f88c[length];
                m.c(v1Var);
                v1Var.z(coroutineContext, this.f87b[length]);
                if (i10 >= 0) {
                    length = i10;
                } else {
                    return;
                }
            }
        }
    }
}
