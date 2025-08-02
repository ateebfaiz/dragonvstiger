package kotlin.jvm.internal;

import zb.c;
import zb.d;
import zb.e;
import zb.g;
import zb.j;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    private static final a0 f726a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f727b = new c[0];

    static {
        a0 a0Var = null;
        try {
            a0Var = (a0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (a0Var == null) {
            a0Var = new a0();
        }
        f726a = a0Var;
    }

    public static e a(i iVar) {
        return f726a.a(iVar);
    }

    public static c b(Class cls) {
        return f726a.b(cls);
    }

    public static d c(Class cls) {
        return f726a.c(cls, "");
    }

    public static g d(o oVar) {
        return f726a.d(oVar);
    }

    public static j e(s sVar) {
        return f726a.e(sVar);
    }

    public static String f(h hVar) {
        return f726a.f(hVar);
    }

    public static String g(n nVar) {
        return f726a.g(nVar);
    }
}
