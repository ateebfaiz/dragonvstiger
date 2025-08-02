package f1;

import com.google.android.games.paddleboat.GameControllerManager;
import f1.j;
import f1.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.w3c.dom.Element;

public class f implements u, s {
    private static final Charset E = Charset.forName("UTF-8");
    private static final Object F = new Object();
    private static final Iterator G = new d();
    private static final k.a H = new g();
    private static final byte[] I = {110, 117, 108, 108};
    private final ConcurrentMap A = new ConcurrentHashMap();
    private final k.a B = new e();
    private final k.a C = new C0274f();
    private final k.a D = new h();

    /* renamed from: a  reason: collision with root package name */
    public final Object f21318a;

    /* renamed from: b  reason: collision with root package name */
    protected final i f21319b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f21320c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21321d;

    /* renamed from: e  reason: collision with root package name */
    protected final q f21322e;

    /* renamed from: f  reason: collision with root package name */
    protected final q f21323f;

    /* renamed from: g  reason: collision with root package name */
    protected final List f21324g;

    /* renamed from: h  reason: collision with root package name */
    private final int f21325h;

    /* renamed from: i  reason: collision with root package name */
    protected final List f21326i;

    /* renamed from: j  reason: collision with root package name */
    private final int f21327j;

    /* renamed from: k  reason: collision with root package name */
    protected final List f21328k;

    /* renamed from: l  reason: collision with root package name */
    private final int f21329l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final j.d f21330m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final j.b f21331n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final j.g f21332o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final int f21333p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final int f21334q;

    /* renamed from: r  reason: collision with root package name */
    protected final ThreadLocal f21335r;

    /* renamed from: s  reason: collision with root package name */
    protected final ThreadLocal f21336s;

    /* renamed from: t  reason: collision with root package name */
    private final g f21337t;

    /* renamed from: u  reason: collision with root package name */
    private final Map f21338u;

    /* renamed from: v  reason: collision with root package name */
    private final Map f21339v = new ConcurrentHashMap();

    /* renamed from: w  reason: collision with root package name */
    private final ConcurrentMap f21340w = new ConcurrentHashMap();

    /* renamed from: x  reason: collision with root package name */
    private final ConcurrentMap f21341x = new ConcurrentHashMap();

    /* renamed from: y  reason: collision with root package name */
    private final ConcurrentMap f21342y = new ConcurrentHashMap();

    /* renamed from: z  reason: collision with root package name */
    private final ConcurrentMap f21343z = new ConcurrentHashMap();

    class a extends ThreadLocal {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f21344a;

        a(f fVar) {
            this.f21344a = fVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public k initialValue() {
            return new k(4096, (u) this.f21344a);
        }
    }

    class b extends ThreadLocal {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f21346a;

        b(f fVar) {
            this.f21346a = fVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public j initialValue() {
            f fVar = this.f21346a;
            return new j(new byte[4096], 4096, fVar.f21318a, new char[64], fVar.f21322e, fVar.f21323f, (s) fVar, fVar.f21330m, this.f21346a.f21331n, this.f21346a.f21332o, this.f21346a.f21333p, this.f21346a.f21334q);
        }
    }

    class c implements k.a {
        c() {
        }

        /* renamed from: b */
        public void a(k kVar, Map map) {
            if (map == null) {
                kVar.n();
                return;
            }
            try {
                f.this.y(map, kVar);
            } catch (IOException e10) {
                throw new p((Throwable) e10);
            }
        }
    }

    class d implements Iterator {
        d() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

        public void remove() {
        }
    }

    class e implements k.a {
        e() {
        }

        public /* bridge */ /* synthetic */ void a(k kVar, Object obj) {
            c.d.a(obj);
            b(kVar, (i) null);
        }

        public void b(k kVar, i iVar) {
            if (iVar == null) {
                kVar.n();
            } else {
                iVar.a(kVar, f.this.f21320c);
            }
        }
    }

    /* renamed from: f1.f$f  reason: collision with other inner class name */
    class C0274f implements k.a {
        C0274f() {
        }

        public void a(k kVar, Object obj) {
            f.this.v(kVar, (i[]) obj);
        }
    }

    class g implements k.a {
        g() {
        }

        public void a(k kVar, Object obj) {
            r.a(new String((char[]) obj), kVar);
        }
    }

    class h implements k.a {
        h() {
        }

        public void a(k kVar, Object obj) {
            kVar.n();
        }
    }

    public interface i {
        void a(Object obj, OutputStream outputStream);

        Object b(Object obj, Type type, InputStream inputStream);
    }

    public static class k {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object f21356a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f21357b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public i f21358c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f21359d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f21360e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public q f21361f = new l();
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public q f21362g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f21363h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public j.d f21364i = j.d.WITH_STACK_TRACE;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public j.b f21365j = j.b.DEFAULT;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public j.g f21366k = j.g.LONG_AND_BIGDECIMAL;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f21367l = 512;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f21368m = GameControllerManager.DEVICEFLAG_VIBRATION;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public final List f21369n = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public final List f21370o = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public final List f21371p = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public final List f21372q = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public final Set f21373r = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public final Map f21374s = new HashMap();

        public k t(i iVar) {
            this.f21358c = iVar;
            return this;
        }
    }

    public static class l implements q {

        /* renamed from: a  reason: collision with root package name */
        private final int f21375a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f21376b;

        public l() {
            this(10);
        }

        private String b(int i10, char[] cArr, int i11) {
            String str = new String(cArr, 0, i11);
            this.f21376b[i10] = str;
            return str;
        }

        public String a(char[] cArr, int i10) {
            long j10 = -2128831035;
            for (int i11 = 0; i11 < i10; i11++) {
                j10 = (j10 ^ ((long) ((byte) cArr[i11]))) * 16777619;
            }
            int i12 = ((int) j10) & this.f21375a;
            String str = this.f21376b[i12];
            if (str == null) {
                return b(i12, cArr, i10);
            }
            if (str.length() != i10) {
                return b(i12, cArr, i10);
            }
            for (int i13 = 0; i13 < str.length(); i13++) {
                if (str.charAt(i13) != cArr[i13]) {
                    return b(i12, cArr, i10);
                }
            }
            return str;
        }

        public l(int i10) {
            int i11 = 2;
            for (int i12 = 1; i12 < i10; i12++) {
                i11 *= 2;
            }
            this.f21375a = i11 - 1;
            this.f21376b = new String[i11];
        }
    }

    public f(k kVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f21324g = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.f21326i = copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        this.f21328k = copyOnWriteArrayList3;
        if (kVar != null) {
            this.f21335r = new a(this);
            this.f21336s = new b(this);
            this.f21318a = kVar.f21356a;
            this.f21319b = kVar.f21358c;
            this.f21320c = kVar.f21359d;
            this.f21321d = kVar.f21360e;
            this.f21322e = kVar.f21361f;
            this.f21323f = kVar.f21362g;
            this.f21332o = kVar.f21366k;
            this.f21330m = kVar.f21364i;
            this.f21331n = kVar.f21365j;
            this.f21333p = kVar.f21367l;
            this.f21334q = kVar.f21368m;
            copyOnWriteArrayList.addAll(kVar.f21370o);
            this.f21325h = kVar.f21370o.size();
            copyOnWriteArrayList2.addAll(kVar.f21371p);
            this.f21327j = kVar.f21371p.size();
            copyOnWriteArrayList3.addAll(kVar.f21372q);
            this.f21329l = kVar.f21372q.size();
            this.f21337t = new g(kVar.f21373r);
            this.f21338u = new HashMap(kVar.f21374s);
            Class<byte[]> cls = byte[].class;
            s(cls, b.f21310a);
            t(cls, b.f21311b);
            Class cls2 = Boolean.TYPE;
            s(cls2, c.f21313b);
            k.a aVar = c.f21315d;
            t(cls2, aVar);
            q(cls2, Boolean.FALSE);
            Class<boolean[]> cls3 = boolean[].class;
            s(cls3, c.f21316e);
            t(cls3, c.f21317f);
            Class<Boolean> cls4 = Boolean.class;
            s(cls4, c.f21314c);
            t(cls4, aVar);
            if (kVar.f21357b) {
                r(this);
            }
            j.f fVar = n.f21484b;
            s(LinkedHashMap.class, fVar);
            s(HashMap.class, fVar);
            Class<Map> cls5 = Map.class;
            s(cls5, fVar);
            t(cls5, new c());
            Class<URI> cls6 = URI.class;
            s(cls6, l.f21451a);
            t(cls6, l.f21452b);
            Class<InetAddress> cls7 = InetAddress.class;
            s(cls7, l.f21453c);
            t(cls7, l.f21454d);
            Class cls8 = Double.TYPE;
            s(cls8, m.f21470p);
            k.a aVar2 = m.f21472r;
            t(cls8, aVar2);
            q(cls8, Double.valueOf(0.0d));
            Class<double[]> cls9 = double[].class;
            s(cls9, m.f21473s);
            t(cls9, m.f21474t);
            Class<Double> cls10 = Double.class;
            s(cls10, m.f21471q);
            t(cls10, aVar2);
            Class cls11 = Float.TYPE;
            s(cls11, m.f21475u);
            k.a aVar3 = m.f21477w;
            t(cls11, aVar3);
            q(cls11, Float.valueOf(0.0f));
            Class<float[]> cls12 = float[].class;
            s(cls12, m.f21478x);
            t(cls12, m.f21479y);
            Class<Float> cls13 = Float.class;
            s(cls13, m.f21476v);
            t(cls13, aVar3);
            Class cls14 = Integer.TYPE;
            s(cls14, m.f21480z);
            k.a aVar4 = m.B;
            t(cls14, aVar4);
            q(cls14, 0);
            Class<int[]> cls15 = int[].class;
            s(cls15, m.C);
            t(cls15, m.D);
            Class<Integer> cls16 = Integer.class;
            s(cls16, m.A);
            t(cls16, aVar4);
            Class cls17 = Short.TYPE;
            s(cls17, m.E);
            k.a aVar5 = m.G;
            t(cls17, aVar5);
            q(cls17, (short) 0);
            Class<short[]> cls18 = short[].class;
            s(cls18, m.H);
            t(cls18, m.I);
            Class<Short> cls19 = Short.class;
            s(cls19, m.F);
            t(cls19, aVar5);
            Class cls20 = Long.TYPE;
            s(cls20, m.J);
            k.a aVar6 = m.L;
            t(cls20, aVar6);
            q(cls20, 0L);
            Class<long[]> cls21 = long[].class;
            s(cls21, m.M);
            t(cls21, m.N);
            Class<Long> cls22 = Long.class;
            s(cls22, m.K);
            t(cls22, aVar6);
            Class<BigDecimal> cls23 = BigDecimal.class;
            s(cls23, m.O);
            t(cls23, m.P);
            Class<String> cls24 = String.class;
            s(cls24, r.f21485a);
            t(cls24, r.f21486b);
            Class<UUID> cls25 = UUID.class;
            s(cls25, t.f21491b);
            t(cls25, t.f21492c);
            s(Number.class, m.Q);
            t(CharSequence.class, r.f21487c);
            s(StringBuilder.class, r.f21488d);
            s(StringBuffer.class, r.f21489e);
            Iterator it = kVar.f21369n.iterator();
            if (it.hasNext()) {
                c.d.a(it.next());
                throw null;
            } else if (!kVar.f21373r.isEmpty() && kVar.f21363h == 0) {
                n(this, kVar.f21373r, "dsl_json_Annotation_Processor_External_Serialization");
                n(this, kVar.f21373r, "dsl_json.json.ExternalSerialization");
                n(this, kVar.f21373r, "dsl_json_ExternalSerialization");
            }
        } else {
            throw new IllegalArgumentException("settings can't be null");
        }
    }

    private void f(Type type, ConcurrentMap concurrentMap) {
        Type k10;
        if (type instanceof Class) {
            this.f21337t.b((Class) type, this);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.f21337t.b((Class) parameterizedType.getRawType(), this);
            for (Type type2 : parameterizedType.getActualTypeArguments()) {
                if (!concurrentMap.containsKey(type2) && (k10 = k(type2)) != type2 && !concurrentMap.containsKey(k10)) {
                    f(k10, concurrentMap);
                }
            }
        }
    }

    private static Object g(Class cls, List list) {
        int i10 = 0;
        if (cls.isPrimitive()) {
            if (Boolean.TYPE.equals(cls)) {
                boolean[] zArr = new boolean[list.size()];
                while (i10 < list.size()) {
                    zArr[i10] = ((Boolean) list.get(i10)).booleanValue();
                    i10++;
                }
                return zArr;
            } else if (Integer.TYPE.equals(cls)) {
                int[] iArr = new int[list.size()];
                while (i10 < list.size()) {
                    iArr[i10] = ((Integer) list.get(i10)).intValue();
                    i10++;
                }
                return iArr;
            } else if (Long.TYPE.equals(cls)) {
                long[] jArr = new long[list.size()];
                while (i10 < list.size()) {
                    jArr[i10] = ((Long) list.get(i10)).longValue();
                    i10++;
                }
                return jArr;
            } else if (Short.TYPE.equals(cls)) {
                short[] sArr = new short[list.size()];
                while (i10 < list.size()) {
                    sArr[i10] = ((Short) list.get(i10)).shortValue();
                    i10++;
                }
                return sArr;
            } else if (Byte.TYPE.equals(cls)) {
                byte[] bArr = new byte[list.size()];
                while (i10 < list.size()) {
                    bArr[i10] = ((Byte) list.get(i10)).byteValue();
                    i10++;
                }
                return bArr;
            } else if (Float.TYPE.equals(cls)) {
                float[] fArr = new float[list.size()];
                while (i10 < list.size()) {
                    fArr[i10] = ((Float) list.get(i10)).floatValue();
                    i10++;
                }
                return fArr;
            } else if (Double.TYPE.equals(cls)) {
                double[] dArr = new double[list.size()];
                while (i10 < list.size()) {
                    dArr[i10] = ((Double) list.get(i10)).doubleValue();
                    i10++;
                }
                return dArr;
            } else if (Character.TYPE.equals(cls)) {
                char[] cArr = new char[list.size()];
                while (i10 < list.size()) {
                    cArr[i10] = ((Character) list.get(i10)).charValue();
                    i10++;
                }
                return cArr;
            }
        }
        return list.toArray((Object[]) Array.newInstance(cls, 0));
    }

    private static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getUpperBounds().length == 1 && wildcardType.getLowerBounds().length == 0) {
            return wildcardType.getUpperBounds()[0];
        }
        return type;
    }

    private static void l(Class cls, ArrayList arrayList) {
        if (!arrayList.contains(cls)) {
            arrayList.add(cls);
            Class<Object> superclass = cls.getSuperclass();
            if (!(superclass == null || superclass == Object.class)) {
                l(superclass, arrayList);
            }
            for (Class l10 : cls.getInterfaces()) {
                l(l10, arrayList);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void n(f1.f r1, java.util.Set r2, java.lang.String r3) {
        /*
            java.util.Iterator r1 = r2.iterator()
        L_0x0004:
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.Object r2 = r1.next()
            java.lang.ClassLoader r2 = (java.lang.ClassLoader) r2
            java.lang.Class r2 = r2.loadClass(r3)     // Catch:{ Exception | NoClassDefFoundError -> 0x0004 }
            r0 = 0
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r0)     // Catch:{ Exception | NoClassDefFoundError -> 0x0004 }
            java.lang.Object r2 = r2.newInstance(r0)     // Catch:{ Exception | NoClassDefFoundError -> 0x0004 }
            c.d.a(r2)     // Catch:{ Exception | NoClassDefFoundError -> 0x0004 }
            throw r0     // Catch:{  }
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.f.n(f1.f, java.util.Set, java.lang.String):void");
    }

    private Object o(Type type, Type type2, List list, ConcurrentMap concurrentMap) {
        if (type2 instanceof Class) {
            this.f21337t.b((Class) type2, this);
            Object obj = concurrentMap.get(type2);
            if (obj != null) {
                return obj;
            }
        } else if (type2 instanceof ParameterizedType) {
            f(type2, concurrentMap);
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        c.d.a(it.next());
        throw null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f1.j.e p(java.lang.Class r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "JSON_READER"
            r1 = 0
            java.lang.reflect.Field r2 = r4.getField(r0)     // Catch:{ Exception -> 0x000b }
            r2.get(r5)     // Catch:{ Exception -> 0x000b }
            goto L_0x001c
        L_0x000b:
            java.lang.reflect.Method r0 = r4.getMethod(r0, r1)     // Catch:{ Exception -> 0x0013 }
            r0.invoke(r5, r1)     // Catch:{ Exception -> 0x0013 }
            goto L_0x001c
        L_0x0013:
            java.lang.String r0 = "getJSON_READER"
            java.lang.reflect.Method r4 = r4.getMethod(r0, r1)     // Catch:{ Exception -> 0x001c }
            r4.invoke(r5, r1)     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.f.p(java.lang.Class, java.lang.Object):f1.j$e");
    }

    static void r(f fVar) {
        Class<Element> cls = Element.class;
        fVar.s(cls, v.f21495a);
        fVar.t(cls, v.f21496b);
    }

    public j.f A(Type type) {
        j.f fVar;
        j.f fVar2 = (j.f) this.f21341x.get(type);
        if (fVar2 != null) {
            return fVar2;
        }
        Type k10 = k(type);
        if (k10 == type || (fVar = (j.f) this.f21341x.get(k10)) == null) {
            if (k10 instanceof Class) {
                Class cls = (Class) k10;
                if (i.class.isAssignableFrom(cls)) {
                    m(cls);
                }
            }
            return (j.f) o(type, k10, this.f21326i, this.f21341x);
        }
        this.f21341x.putIfAbsent(type, fVar);
        return fVar;
    }

    public k.a B(Class cls) {
        return C(cls);
    }

    public k.a C(Type type) {
        k.a aVar;
        k.a aVar2 = (k.a) this.f21343z.get(type);
        if (aVar2 != null) {
            return aVar2;
        }
        Type k10 = k(type);
        if (k10 == type || (aVar = (k.a) this.f21343z.get(k10)) == null) {
            boolean z10 = k10 instanceof Class;
            if (z10) {
                if (i.class.isAssignableFrom((Class) k10)) {
                    this.f21343z.putIfAbsent(type, this.B);
                    return this.B;
                }
            }
            k.a aVar3 = (k.a) o(type, k10, this.f21324g, this.f21343z);
            if (aVar3 != null) {
                return aVar3;
            }
            if (!z10) {
                return null;
            }
            Class cls = (Class) this.A.get(k10);
            if (cls != null) {
                return (k.a) this.f21343z.get(cls);
            }
            Class cls2 = (Class) k10;
            ArrayList arrayList = new ArrayList();
            l(cls2, arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Class cls3 = (Class) it.next();
                k.a aVar4 = (k.a) this.f21343z.get(cls3);
                if (aVar4 == null) {
                    aVar4 = (k.a) o(type, cls3, this.f21324g, this.f21343z);
                    continue;
                }
                if (aVar4 != null) {
                    this.A.putIfAbsent(cls2, cls3);
                    return aVar4;
                }
            }
            return null;
        }
        this.f21343z.putIfAbsent(type, aVar);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public IOException h(Class cls) {
        ArrayList arrayList = new ArrayList();
        l(cls, arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            if (this.f21341x.containsKey(cls2)) {
                if (cls2.equals(cls)) {
                    return new IOException("Reader for provided type: " + cls + " is disabled and fallback serialization is not registered (converter is registered as null).\nTry initializing system with custom fallback or don't register null for " + cls);
                }
                return new IOException("Unable to find reader for provided type: " + cls + " and fallback serialization is not registered.\nFound reader for: " + cls2 + " so try deserializing into that instead?\nAlternatively, try initializing system with custom fallback or register specified type using registerReader into " + getClass());
            }
        }
        return new IOException("Unable to find reader for provided type: " + cls + " and fallback serialization is not registered.\nTry initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
    }

    /* access modifiers changed from: protected */
    public Object i(Class cls, j jVar, InputStream inputStream) {
        jVar.h();
        j.f z10 = z(cls);
        if (z10 != null) {
            return z10.a(jVar);
        }
        if (cls.isArray()) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                Class<?> componentType = cls.getComponentType();
                if (jVar.h() == 93) {
                    return Array.newInstance(componentType, 0);
                }
                if (i.class.isAssignableFrom(componentType)) {
                    m(componentType);
                }
                j.f z11 = z(componentType);
                if (z11 != null) {
                    return g(componentType, jVar.f(z11));
                }
            } else {
                throw jVar.n("Expecting '[' for array start");
            }
        }
        i iVar = this.f21319b;
        if (iVar != null) {
            return iVar.b(this.f21318a, cls, new j(jVar.f21410h, inputStream));
        }
        throw h(cls);
    }

    public Object j(Class cls, InputStream inputStream) {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        } else if (inputStream != null) {
            j z10 = ((j) this.f21336s.get()).z(inputStream);
            try {
                return i(cls, z10, inputStream);
            } finally {
                z10.H();
            }
        } else {
            throw new IllegalArgumentException("stream can't be null");
        }
    }

    /* access modifiers changed from: protected */
    public final j.e m(Class cls) {
        try {
            c.d.a(this.f21340w.get(cls));
            p(cls, (Object) null);
            Object obj = cls.getField("Companion").get((Object) null);
            p(obj.getClass(), obj);
        } catch (Exception unused) {
        }
        return null;
    }

    public void q(Class cls, Object obj) {
        this.f21339v.put(cls, obj);
    }

    public void s(Class cls, j.f fVar) {
        if (fVar == null) {
            this.f21341x.remove(cls);
        } else {
            this.f21341x.put(cls, fVar);
        }
    }

    public void t(Class cls, k.a aVar) {
        if (aVar == null) {
            this.A.remove(cls);
            this.f21343z.remove(cls);
            return;
        }
        this.A.put(cls, cls);
        this.f21343z.put(cls, aVar);
    }

    public final void u(k kVar, Object obj) {
        if (kVar == null) {
            throw new IllegalArgumentException("writer can't be null");
        } else if (obj == null) {
            kVar.n();
        } else {
            Class<?> cls = obj.getClass();
            if (x(kVar, cls, obj)) {
                return;
            }
            if (this.f21319b != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f21319b.a(obj, byteArrayOutputStream);
                kVar.j(byteArrayOutputStream.toByteArray());
                return;
            }
            throw new e("Unable to serialize provided object. Failed to find serializer for: " + cls);
        }
    }

    public void v(k kVar, i[] iVarArr) {
        if (iVarArr == null) {
            kVar.n();
            return;
        }
        kVar.l((byte) 91);
        if (iVarArr.length != 0) {
            i iVar = iVarArr[0];
            kVar.n();
            for (int i10 = 1; i10 < iVarArr.length; i10++) {
                kVar.l((byte) 44);
                i iVar2 = iVarArr[i10];
                kVar.n();
            }
        }
        kVar.l((byte) 93);
    }

    public final void w(Object obj, OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        } else if (obj == null) {
            outputStream.write(I);
        } else {
            k kVar = (k) this.f21335r.get();
            kVar.e(outputStream);
            Class<?> cls = obj.getClass();
            if (!x(kVar, cls, obj)) {
                i iVar = this.f21319b;
                if (iVar != null) {
                    iVar.a(obj, outputStream);
                    return;
                }
                throw new e("Unable to serialize provided object. Failed to find serializer for: " + cls);
            }
            kVar.d();
            kVar.e((OutputStream) null);
        }
    }

    public boolean x(k kVar, Type type, Object obj) {
        Class cls;
        List list;
        if (kVar == null) {
            throw new IllegalArgumentException("writer can't be null");
        } else if (obj == null) {
            try {
                kVar.n();
                return true;
            } catch (ClassCastException unused) {
                return false;
            }
        } else if (obj instanceof i[]) {
            v(kVar, (i[]) obj);
            return true;
        } else {
            k.a C2 = C(type);
            if (C2 != null) {
                C2.a(kVar, obj);
                return true;
            }
            Class<?> cls2 = null;
            if (type instanceof Class) {
                cls = (Class) type;
            } else {
                cls = null;
            }
            if (cls != null) {
                if (cls.isArray()) {
                    if (Array.getLength(obj) == 0) {
                        kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        return true;
                    }
                    Class<?> componentType = cls.getComponentType();
                    if (Character.TYPE == componentType) {
                        r.a(new String((char[]) obj), kVar);
                        return true;
                    }
                    k.a B2 = B(componentType);
                    if (B2 != null) {
                        kVar.g((Object[]) obj, B2);
                        return true;
                    }
                }
            }
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                if (collection.isEmpty()) {
                    kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return true;
                }
                Iterator it = collection.iterator();
                boolean z10 = collection instanceof List;
                if (z10) {
                    list = (List) collection;
                } else {
                    list = new ArrayList();
                }
                ArrayList arrayList = new ArrayList();
                boolean z11 = false;
                Class<?> cls3 = null;
                k.a aVar = null;
                do {
                    Object next = it.next();
                    if (!z10) {
                        list.add(next);
                    }
                    if (next != null) {
                        Class<?> cls4 = next.getClass();
                        if (cls4 != cls2 && (cls2 == null || cls4.isAssignableFrom(cls2))) {
                            cls2 = cls4;
                        }
                        if (cls3 != cls4) {
                            aVar = B(cls4);
                            cls3 = cls4;
                        }
                        arrayList.add(aVar);
                        if (!z11) {
                            if (aVar != null) {
                                z11 = false;
                            }
                        }
                        z11 = true;
                    } else {
                        arrayList.add(this.D);
                    }
                } while (it.hasNext());
                if (cls2 != null && i.class.isAssignableFrom(cls2)) {
                    kVar.l((byte) 91);
                    Iterator it2 = list.iterator();
                    c.d.a(it2.next());
                    kVar.n();
                    while (it2.hasNext()) {
                        kVar.l((byte) 44);
                        c.d.a(it2.next());
                        kVar.n();
                    }
                    kVar.l((byte) 93);
                    return true;
                } else if (!z11) {
                    kVar.l((byte) 91);
                    Iterator it3 = list.iterator();
                    ((k.a) arrayList.get(0)).a(kVar, it3.next());
                    int i10 = 1;
                    while (it3.hasNext()) {
                        kVar.l((byte) 44);
                        ((k.a) arrayList.get(i10)).a(kVar, it3.next());
                        i10++;
                    }
                    kVar.l((byte) 93);
                    return true;
                } else {
                    k.a B3 = B(cls2);
                    if (B3 != null) {
                        kVar.f(collection, B3);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void y(Map map, k kVar) {
        kVar.l((byte) 123);
        int size = map.size();
        if (size > 0) {
            Iterator it = map.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            kVar.q((String) entry.getKey());
            kVar.l((byte) 58);
            u(kVar, entry.getValue());
            for (int i10 = 1; i10 < size; i10++) {
                kVar.l((byte) 44);
                Map.Entry entry2 = (Map.Entry) it.next();
                kVar.q((String) entry2.getKey());
                kVar.l((byte) 58);
                u(kVar, entry2.getValue());
            }
        }
        kVar.l((byte) 125);
    }

    public j.f z(Class cls) {
        return A(cls);
    }

    static class j extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f21352a;

        /* renamed from: b  reason: collision with root package name */
        private final InputStream f21353b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21354c = true;

        /* renamed from: d  reason: collision with root package name */
        private int f21355d;

        j(byte[] bArr, InputStream inputStream) {
            this.f21352a = bArr;
            this.f21353b = inputStream;
        }

        public int read() {
            if (this.f21354c) {
                int i10 = this.f21355d;
                byte[] bArr = this.f21352a;
                if (i10 < bArr.length) {
                    this.f21355d = i10 + 1;
                    return bArr[i10];
                }
                this.f21354c = false;
            }
            return this.f21353b.read();
        }

        public int read(byte[] bArr) {
            if (this.f21354c) {
                return super.read(bArr);
            }
            return this.f21353b.read(bArr);
        }

        public int read(byte[] bArr, int i10, int i11) {
            if (this.f21354c) {
                return super.read(bArr, i10, i11);
            }
            return this.f21353b.read(bArr, i10, i11);
        }
    }
}
