package ba;

import aa.i;
import aa.l;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import y9.h;
import y9.k;
import y9.m;
import y9.o;
import y9.r;
import y9.s;

public final class j implements s {

    /* renamed from: a  reason: collision with root package name */
    private final aa.c f2539a;

    /* renamed from: b  reason: collision with root package name */
    private final y9.c f2540b;

    /* renamed from: c  reason: collision with root package name */
    private final aa.d f2541c;

    /* renamed from: d  reason: collision with root package name */
    private final e f2542d;

    /* renamed from: e  reason: collision with root package name */
    private final List f2543e;

    class a extends c {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f2544f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Method f2545g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f2546h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ r f2547i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ y9.d f2548j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ fa.a f2549k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f2550l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f2551m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, r rVar, y9.d dVar, fa.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f2544f = z12;
            this.f2545g = method;
            this.f2546h = z13;
            this.f2547i = rVar;
            this.f2548j = dVar;
            this.f2549k = aVar;
            this.f2550l = z14;
            this.f2551m = z15;
        }

        /* access modifiers changed from: package-private */
        public void a(ga.a aVar, int i10, Object[] objArr) {
            Object b10 = this.f2547i.b(aVar);
            if (b10 != null || !this.f2550l) {
                objArr[i10] = b10;
                return;
            }
            throw new k("null is not allowed as value for record component '" + this.f2556c + "' of primitive type; at path " + aVar.getPath());
        }

        /* access modifiers changed from: package-private */
        public void b(ga.a aVar, Object obj) {
            Object b10 = this.f2547i.b(aVar);
            if (b10 != null || !this.f2550l) {
                if (this.f2544f) {
                    j.c(obj, this.f2555b);
                } else if (this.f2551m) {
                    String g10 = da.a.g(this.f2555b, false);
                    throw new h("Cannot set value of 'static final' " + g10);
                }
                this.f2555b.set(obj, b10);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(ga.c cVar, Object obj) {
            Object obj2;
            r rVar;
            if (this.f2557d) {
                if (this.f2544f) {
                    Method method = this.f2545g;
                    if (method == null) {
                        j.c(obj, this.f2555b);
                    } else {
                        j.c(obj, method);
                    }
                }
                Method method2 = this.f2545g;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, (Object[]) null);
                    } catch (InvocationTargetException e10) {
                        String g10 = da.a.g(this.f2545g, false);
                        throw new h("Accessor " + g10 + " threw exception", e10.getCause());
                    }
                } else {
                    obj2 = this.f2555b.get(obj);
                }
                if (obj2 != obj) {
                    cVar.z(this.f2554a);
                    if (this.f2546h) {
                        rVar = this.f2547i;
                    } else {
                        rVar = new l(this.f2548j, this.f2547i, this.f2549k.e());
                    }
                    rVar.d(cVar, obj2);
                }
            }
        }
    }

    public static abstract class b extends r {

        /* renamed from: a  reason: collision with root package name */
        final Map f2553a;

        b(Map map) {
            this.f2553a = map;
        }

        public Object b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            Object e10 = e();
            try {
                aVar.b();
                while (aVar.y()) {
                    c cVar = (c) this.f2553a.get(aVar.I());
                    if (cVar != null) {
                        if (cVar.f2558e) {
                            g(e10, aVar, cVar);
                        }
                    }
                    aVar.Y();
                }
                aVar.n();
                return f(e10);
            } catch (IllegalStateException e11) {
                throw new m((Throwable) e11);
            } catch (IllegalAccessException e12) {
                throw da.a.e(e12);
            }
        }

        public void d(ga.c cVar, Object obj) {
            if (obj == null) {
                cVar.B();
                return;
            }
            cVar.j();
            try {
                for (c c10 : this.f2553a.values()) {
                    c10.c(cVar, obj);
                }
                cVar.n();
            } catch (IllegalAccessException e10) {
                throw da.a.e(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Object e();

        /* access modifiers changed from: package-private */
        public abstract Object f(Object obj);

        /* access modifiers changed from: package-private */
        public abstract void g(Object obj, ga.a aVar, c cVar);
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f2554a;

        /* renamed from: b  reason: collision with root package name */
        final Field f2555b;

        /* renamed from: c  reason: collision with root package name */
        final String f2556c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f2557d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f2558e;

        protected c(String str, Field field, boolean z10, boolean z11) {
            this.f2554a = str;
            this.f2555b = field;
            this.f2556c = field.getName();
            this.f2557d = z10;
            this.f2558e = z11;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(ga.a aVar, int i10, Object[] objArr);

        /* access modifiers changed from: package-private */
        public abstract void b(ga.a aVar, Object obj);

        /* access modifiers changed from: package-private */
        public abstract void c(ga.c cVar, Object obj);
    }

    private static final class d extends b {

        /* renamed from: b  reason: collision with root package name */
        private final i f2559b;

        d(i iVar, Map map) {
            super(map);
            this.f2559b = iVar;
        }

        /* access modifiers changed from: package-private */
        public Object e() {
            return this.f2559b.construct();
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void g(Object obj, ga.a aVar, c cVar) {
            cVar.b(aVar, obj);
        }
    }

    private static final class e extends b {

        /* renamed from: e  reason: collision with root package name */
        static final Map f2560e = j();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor f2561b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f2562c;

        /* renamed from: d  reason: collision with root package name */
        private final Map f2563d = new HashMap();

        e(Class cls, Map map, boolean z10) {
            super(map);
            Constructor i10 = da.a.i(cls);
            this.f2561b = i10;
            if (z10) {
                j.c((Object) null, i10);
            } else {
                da.a.l(i10);
            }
            String[] j10 = da.a.j(cls);
            for (int i11 = 0; i11 < j10.length; i11++) {
                this.f2563d.put(j10[i11], Integer.valueOf(i11));
            }
            Class[] parameterTypes = this.f2561b.getParameterTypes();
            this.f2562c = new Object[parameterTypes.length];
            for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                this.f2562c[i12] = f2560e.get(parameterTypes[i12]);
            }
        }

        private static Map j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Object[] e() {
            return (Object[]) this.f2562c.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Object f(Object[] objArr) {
            try {
                return this.f2561b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw da.a.e(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + da.a.c(this.f2561b) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + da.a.c(this.f2561b) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void g(Object[] objArr, ga.a aVar, c cVar) {
            Integer num = (Integer) this.f2563d.get(cVar.f2556c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + da.a.c(this.f2561b) + "' for field with name '" + cVar.f2556c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public j(aa.c cVar, y9.c cVar2, aa.d dVar, e eVar, List list) {
        this.f2539a = cVar;
        this.f2540b = cVar2;
        this.f2541c = dVar;
        this.f2542d = eVar;
        this.f2543e = list;
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!l.a(accessibleObject, obj)) {
            String g10 = da.a.g(accessibleObject, true);
            throw new h(g10 + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private c d(y9.d dVar, Field field, Method method, String str, fa.a aVar, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        r rVar;
        boolean z14;
        y9.d dVar2 = dVar;
        fa.a aVar2 = aVar;
        boolean a10 = aa.k.a(aVar.d());
        int modifiers = field.getModifiers();
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z13 = false;
        } else {
            z13 = true;
        }
        z9.b bVar = (z9.b) field.getAnnotation(z9.b.class);
        if (bVar != null) {
            rVar = this.f2542d.b(this.f2539a, dVar2, aVar2, bVar);
        } else {
            rVar = null;
        }
        if (rVar != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (rVar == null) {
            rVar = dVar2.k(aVar2);
        }
        return new a(str, field, z10, z11, z12, method, z14, rVar, dVar, aVar, a10, z13);
    }

    private Map e(y9.d dVar, fa.a aVar, Class cls, boolean z10, boolean z11) {
        boolean z12;
        int i10;
        int i11;
        Method method;
        boolean z13;
        boolean z14;
        j jVar = this;
        Class cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        fa.a aVar2 = aVar;
        boolean z15 = z10;
        Class cls3 = cls2;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            boolean z16 = true;
            boolean z17 = false;
            if (cls3 != cls2 && declaredFields.length > 0) {
                o b10 = l.b(jVar.f2543e, cls3);
                if (b10 == o.BLOCK_ALL) {
                    throw new h("ReflectionAccessFilter does not permit using reflection for " + cls3 + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                } else if (b10 == o.BLOCK_INACCESSIBLE) {
                    z15 = true;
                } else {
                    z15 = false;
                }
            }
            boolean z18 = z15;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean g10 = jVar.g(field, z16);
                boolean g11 = jVar.g(field, z17);
                if (g10 || g11) {
                    c cVar = null;
                    if (!z11) {
                        z13 = g11;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z13 = z17;
                    } else {
                        Method h10 = da.a.h(cls3, field);
                        if (!z18) {
                            da.a.l(h10);
                        }
                        Class cls4 = z9.c.class;
                        if (h10.getAnnotation(cls4) == null || field.getAnnotation(cls4) != null) {
                            z13 = g11;
                            method = h10;
                        } else {
                            throw new h("@SerializedName on " + da.a.g(h10, z17) + " is not supported");
                        }
                    }
                    if (!z18 && method == null) {
                        da.a.l(field);
                    }
                    Type o10 = aa.b.o(aVar2.e(), cls3, field.getGenericType());
                    List f10 = jVar.f(field);
                    int size = f10.size();
                    int i13 = z17;
                    while (i13 < size) {
                        String str = (String) f10.get(i13);
                        if (i13 != 0) {
                            z14 = z17;
                        } else {
                            z14 = g10;
                        }
                        int i14 = i13;
                        c cVar2 = cVar;
                        int i15 = size;
                        List list = f10;
                        Field field2 = field;
                        int i16 = i12;
                        int i17 = length;
                        boolean z19 = z17;
                        c cVar3 = (c) linkedHashMap.put(str, d(dVar, field, method, str, fa.a.b(o10), z14, z13, z18));
                        if (cVar2 == null) {
                            cVar = cVar3;
                        } else {
                            cVar = cVar2;
                        }
                        i13 = i14 + 1;
                        g10 = z14;
                        i12 = i16;
                        size = i15;
                        f10 = list;
                        field = field2;
                        length = i17;
                        z17 = z19;
                    }
                    c cVar4 = cVar;
                    Field field3 = field;
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                    if (cVar4 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar4.f2554a + "'; conflict is caused by fields " + da.a.f(cVar4.f2555b) + " and " + da.a.f(field3));
                    }
                } else {
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                }
                i12 = i11 + 1;
                z16 = true;
                jVar = this;
                length = i10;
                z17 = z12;
            }
            aVar2 = fa.a.b(aa.b.o(aVar2.e(), cls3, cls3.getGenericSuperclass()));
            cls3 = aVar2.d();
            jVar = this;
            z15 = z18;
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        z9.c cVar = (z9.c) field.getAnnotation(z9.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f2540b.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z10) {
        if (this.f2541c.c(field.getType(), z10) || this.f2541c.f(field, z10)) {
            return false;
        }
        return true;
    }

    public r a(y9.d dVar, fa.a aVar) {
        boolean z10;
        Class d10 = aVar.d();
        if (!Object.class.isAssignableFrom(d10)) {
            return null;
        }
        o b10 = l.b(this.f2543e, d10);
        if (b10 != o.BLOCK_ALL) {
            if (b10 == o.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z11 = z10;
            if (da.a.k(d10)) {
                return new e(d10, e(dVar, aVar, d10, z11, true), z11);
            }
            return new d(this.f2539a.b(aVar), e(dVar, aVar, d10, z11, false));
        }
        throw new h("ReflectionAccessFilter does not permit using reflection for " + d10 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
