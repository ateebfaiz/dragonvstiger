package kotlin.jvm.internal;

import com.adjust.sdk.Constants;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import vb.b;
import vb.d;
import vb.f;
import vb.g;
import vb.h;
import vb.i;
import vb.j;
import vb.k;
import vb.l;
import vb.m;
import vb.n;
import vb.o;
import vb.p;
import vb.q;
import vb.s;
import vb.t;
import zb.c;

public final class e implements c, d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f711b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map f712c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap f713d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap f714e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f715f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Map f716g;

    /* renamed from: a  reason: collision with root package name */
    private final Class f717a;

    public static final class a {
        private a() {
        }

        public final String a(Class cls) {
            String str;
            m.f(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) e.f715f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) e.f715f.get(cls.getName());
            if (str3 == null) {
                return cls.getCanonicalName();
            }
            return str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003b, code lost:
            if (r2 == null) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String b(java.lang.Class r7) {
            /*
                r6 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.m.f(r7, r0)
                boolean r0 = r7.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto L_0x000e
                goto L_0x00b3
            L_0x000e:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L_0x006a
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r2 = r7.getEnclosingMethod()
                r3 = 2
                r4 = 36
                if (r2 == 0) goto L_0x0041
                kotlin.jvm.internal.m.c(r0)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = r2.getName()
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                java.lang.String r2 = kotlin.text.j.G0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L_0x003e
                goto L_0x0041
            L_0x003e:
                r1 = r2
                goto L_0x00b3
            L_0x0041:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L_0x0062
                kotlin.jvm.internal.m.c(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r7.getName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r7 = r2.toString()
                java.lang.String r1 = kotlin.text.j.G0(r0, r7, r1, r3, r1)
                goto L_0x00b3
            L_0x0062:
                kotlin.jvm.internal.m.c(r0)
                java.lang.String r1 = kotlin.text.j.F0(r0, r4, r1, r3, r1)
                goto L_0x00b3
            L_0x006a:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L_0x009e
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L_0x009b
                java.util.Map r0 = kotlin.jvm.internal.e.f716g
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L_0x009b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L_0x009b:
                if (r1 != 0) goto L_0x00b3
                goto L_0x003e
            L_0x009e:
                java.util.Map r0 = kotlin.jvm.internal.e.f716g
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L_0x00b3
                java.lang.String r1 = r7.getSimpleName()
            L_0x00b3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.e.a.b(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i10 = 0;
        Iterable o10 = r.o(Function0.class, Function1.class, Function2.class, n.class, o.class, p.class, q.class, vb.r.class, s.class, t.class, vb.a.class, b.class, vb.c.class, d.class, vb.e.class, f.class, g.class, h.class, i.class, j.class, k.class, l.class, m.class);
        ArrayList arrayList = new ArrayList(r.v(o10, 10));
        for (Object next : o10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.u();
            }
            arrayList.add(kotlin.t.a((Class) next, Integer.valueOf(i10)));
            i10 = i11;
        }
        f712c = i0.n(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put(Constants.LONG, "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f713d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f714e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        m.e(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            m.c(str);
            sb2.append(kotlin.text.j.J0(str, JwtParser.SEPARATOR_CHAR, (String) null, 2, (Object) null));
            sb2.append("CompanionObject");
            String sb3 = sb2.toString();
            Pair a10 = kotlin.t.a(sb3, str + ".Companion");
            hashMap3.put(a10.c(), a10.d());
        }
        for (Map.Entry entry : f712c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f715f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(i0.c(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), kotlin.text.j.J0((String) entry2.getValue(), JwtParser.SEPARATOR_CHAR, (String) null, 2, (Object) null));
        }
        f716g = linkedHashMap;
    }

    public e(Class cls) {
        m.f(cls, "jClass");
        this.f717a = cls;
    }

    public String a() {
        return f711b.a(c());
    }

    public String b() {
        return f711b.b(c());
    }

    public Class c() {
        return this.f717a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e) || !m.b(ub.a.b(this), ub.a.b((c) obj))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ub.a.b(this).hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
