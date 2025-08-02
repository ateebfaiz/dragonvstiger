package aa;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2265a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2266b;

    /* renamed from: c  reason: collision with root package name */
    private final List f2267c;

    class a implements i {
        a() {
        }

        public Object construct() {
            return new TreeSet();
        }
    }

    class b implements i {
        b() {
        }

        public Object construct() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: aa.c$c  reason: collision with other inner class name */
    class C0040c implements i {
        C0040c() {
        }

        public Object construct() {
            return new ArrayDeque();
        }
    }

    class d implements i {
        d() {
        }

        public Object construct() {
            return new ArrayList();
        }
    }

    class e implements i {
        e() {
        }

        public Object construct() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements i {
        f() {
        }

        public Object construct() {
            return new ConcurrentHashMap();
        }
    }

    class g implements i {
        g() {
        }

        public Object construct() {
            return new TreeMap();
        }
    }

    class h implements i {
        h() {
        }

        public Object construct() {
            return new LinkedHashMap();
        }
    }

    class i implements i {
        i() {
        }

        public Object construct() {
            return new h();
        }
    }

    class j implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2268a;

        j(Class cls) {
            this.f2268a = cls;
        }

        public Object construct() {
            try {
                return n.f2329a.d(this.f2268a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f2268a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    class k implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2270a;

        k(String str) {
            this.f2270a = str;
        }

        public Object construct() {
            throw new y9.h(this.f2270a);
        }
    }

    class l implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2272a;

        l(String str) {
            this.f2272a = str;
        }

        public Object construct() {
            throw new y9.h(this.f2272a);
        }
    }

    class m implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2274a;

        m(String str) {
            this.f2274a = str;
        }

        public Object construct() {
            throw new y9.h(this.f2274a);
        }
    }

    class n implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f2276a;

        n(Type type) {
            this.f2276a = type;
        }

        public Object construct() {
            Type type = this.f2276a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new y9.h("Invalid EnumSet type: " + this.f2276a.toString());
            }
            throw new y9.h("Invalid EnumSet type: " + this.f2276a.toString());
        }
    }

    class o implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f2277a;

        o(Type type) {
            this.f2277a = type;
        }

        public Object construct() {
            Type type = this.f2277a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new y9.h("Invalid EnumMap type: " + this.f2277a.toString());
            }
            throw new y9.h("Invalid EnumMap type: " + this.f2277a.toString());
        }
    }

    class p implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2278a;

        p(String str) {
            this.f2278a = str;
        }

        public Object construct() {
            throw new y9.h(this.f2278a);
        }
    }

    class q implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2279a;

        q(String str) {
            this.f2279a = str;
        }

        public Object construct() {
            throw new y9.h(this.f2279a);
        }
    }

    class r implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f2280a;

        r(Constructor constructor) {
            this.f2280a = constructor;
        }

        public Object construct() {
            try {
                return this.f2280a.newInstance((Object[]) null);
            } catch (InstantiationException e10) {
                throw new RuntimeException("Failed to invoke constructor '" + da.a.c(this.f2280a) + "' with no args", e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + da.a.c(this.f2280a) + "' with no args", e11.getCause());
            } catch (IllegalAccessException e12) {
                throw da.a.e(e12);
            }
        }
    }

    public c(Map map, boolean z10, List list) {
        this.f2265a = map;
        this.f2266b = z10;
        this.f2267c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
    }

    private static i c(Class cls, y9.o oVar) {
        String m10;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            y9.o oVar2 = y9.o.ALLOW;
            if (oVar != oVar2 && (!l.a(declaredConstructor, (Object) null) || (oVar == y9.o.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            } else if (oVar != oVar2 || (m10 = da.a.m(declaredConstructor)) == null) {
                return new r(declaredConstructor);
            } else {
                return new q(m10);
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static i d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C0040c();
            }
            return new d();
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if (type instanceof ParameterizedType) {
                if (!String.class.isAssignableFrom(fa.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).d())) {
                    return new h();
                }
            }
            return new i();
        }
    }

    private static i e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private i f(Class cls) {
        if (this.f2266b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public i b(fa.a aVar) {
        Type e10 = aVar.e();
        Class d10 = aVar.d();
        c.d.a(this.f2265a.get(e10));
        c.d.a(this.f2265a.get(d10));
        i e11 = e(e10, d10);
        if (e11 != null) {
            return e11;
        }
        y9.o b10 = l.b(this.f2267c, d10);
        i c10 = c(d10, b10);
        if (c10 != null) {
            return c10;
        }
        i d11 = d(e10, d10);
        if (d11 != null) {
            return d11;
        }
        String a10 = a(d10);
        if (a10 != null) {
            return new l(a10);
        }
        if (b10 == y9.o.ALLOW) {
            return f(d10);
        }
        return new m("Unable to create instance of " + d10 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f2265a.toString();
    }
}
