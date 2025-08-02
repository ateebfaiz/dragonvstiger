package cc;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.v1;

public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f66a = new c0("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final Function2 f67b = a.f70a;

    /* renamed from: c  reason: collision with root package name */
    private static final Function2 f68c = b.f71a;

    /* renamed from: d  reason: collision with root package name */
    private static final Function2 f69d = c.f72a;

    static final class a extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Object invoke(Object obj, CoroutineContext.Element element) {
            Integer num;
            int i10;
            if (!(element instanceof v1)) {
                return obj;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = 1;
            }
            if (i10 == 0) {
                return element;
            }
            return Integer.valueOf(i10 + 1);
        }
    }

    static final class b extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f71a = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final v1 invoke(v1 v1Var, CoroutineContext.Element element) {
            if (v1Var != null) {
                return v1Var;
            }
            if (element instanceof v1) {
                return (v1) element;
            }
            return null;
        }
    }

    static final class c extends n implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f72a = new c();

        c() {
            super(2);
        }

        /* renamed from: a */
        public final k0 invoke(k0 k0Var, CoroutineContext.Element element) {
            if (element instanceof v1) {
                v1 v1Var = (v1) element;
                k0Var.a(v1Var, v1Var.C(k0Var.f86a));
            }
            return k0Var;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f66a) {
            if (obj instanceof k0) {
                ((k0) obj).b(coroutineContext);
                return;
            }
            Object fold = coroutineContext.fold((Object) null, f68c);
            m.d(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((v1) fold).z(coroutineContext, obj);
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f67b);
        m.c(fold);
        return fold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f66a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new k0(coroutineContext, ((Number) obj).intValue()), f69d);
        }
        m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((v1) obj).C(coroutineContext);
    }
}
