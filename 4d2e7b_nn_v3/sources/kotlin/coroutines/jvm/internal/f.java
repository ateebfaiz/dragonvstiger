package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f685a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static final a f686b = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    private static a f687c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f688a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f689b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f690c;

        public a(Method method, Method method2, Method method3) {
            this.f688a = method;
            this.f689b = method2;
            this.f690c = method3;
        }
    }

    private f() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", (Class[]) null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", (Class[]) null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", (Class[]) null));
            f687c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f686b;
            f687c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        Object obj;
        Object obj2;
        Object obj3;
        m.f(baseContinuationImpl, "continuation");
        a aVar = f687c;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar == f686b) {
            return null;
        }
        Method method = aVar.f688a;
        if (method != null) {
            obj = method.invoke(baseContinuationImpl.getClass(), (Object[]) null);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = aVar.f689b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, (Object[]) null);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = aVar.f690c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, (Object[]) null);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }
}
