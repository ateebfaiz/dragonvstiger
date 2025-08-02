package j2;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: g  reason: collision with root package name */
    private static g f22195g;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicBoolean f22196h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public static final a f22197i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Class f22198a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f22199b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f22200c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f22201d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f22202e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f22203f;

    public static final class a {
        private a() {
        }

        private final void a() {
            Class a10 = h.a("com.android.billingclient.api.SkuDetailsParams");
            Class a11 = h.a("com.android.billingclient.api.SkuDetailsParams$Builder");
            if (a10 != null && a11 != null) {
                Method b10 = h.b(a10, "newBuilder", new Class[0]);
                Method b11 = h.b(a11, "setType", String.class);
                Method b12 = h.b(a11, "setSkusList", List.class);
                Method b13 = h.b(a11, "build", new Class[0]);
                if (b10 != null && b11 != null && b12 != null && b13 != null) {
                    g.c(new g(a10, a11, b10, b11, b12, b13));
                }
            }
        }

        public final g b() {
            if (g.a().get()) {
                return g.b();
            }
            a();
            g.a().set(true);
            return g.b();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(Class cls, Class cls2, Method method, Method method2, Method method3, Method method4) {
        m.f(cls, "skuDetailsParamsClazz");
        m.f(cls2, "builderClazz");
        m.f(method, "newBuilderMethod");
        m.f(method2, "setTypeMethod");
        m.f(method3, "setSkusListMethod");
        m.f(method4, "buildMethod");
        this.f22198a = cls;
        this.f22199b = cls2;
        this.f22200c = method;
        this.f22201d = method2;
        this.f22202e = method3;
        this.f22203f = method4;
    }

    public static final /* synthetic */ AtomicBoolean a() {
        Class<g> cls = g.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22196h;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ g b() {
        Class<g> cls = g.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22195g;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void c(g gVar) {
        Class<g> cls = g.class;
        if (!v5.a.d(cls)) {
            try {
                f22195g = gVar;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public final Object d(String str, List list) {
        Object c10;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Object c11 = h.c(this.f22198a, this.f22200c, (Object) null, new Object[0]);
            if (c11 == null || (c10 = h.c(this.f22199b, this.f22201d, c11, str)) == null) {
                return null;
            }
            Object c12 = h.c(this.f22199b, this.f22202e, c10, list);
            if (c12 == null) {
                return null;
            }
            return h.c(this.f22199b, this.f22203f, c12, new Object[0]);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final Class e() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f22198a;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }
}
