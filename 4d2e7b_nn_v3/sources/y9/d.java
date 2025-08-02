package y9;

import aa.g;
import ba.h;
import ba.i;
import ba.j;
import ba.k;
import ba.m;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class d {
    static final c A = b.IDENTITY;
    static final q B = p.DOUBLE;
    static final q C = p.LAZILY_PARSED_NUMBER;

    /* renamed from: z  reason: collision with root package name */
    static final String f13371z = null;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f13372a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f13373b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final aa.c f13374c;

    /* renamed from: d  reason: collision with root package name */
    private final ba.e f13375d;

    /* renamed from: e  reason: collision with root package name */
    final List f13376e;

    /* renamed from: f  reason: collision with root package name */
    final aa.d f13377f;

    /* renamed from: g  reason: collision with root package name */
    final c f13378g;

    /* renamed from: h  reason: collision with root package name */
    final Map f13379h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f13380i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f13381j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f13382k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f13383l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f13384m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f13385n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f13386o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f13387p;

    /* renamed from: q  reason: collision with root package name */
    final String f13388q;

    /* renamed from: r  reason: collision with root package name */
    final int f13389r;

    /* renamed from: s  reason: collision with root package name */
    final int f13390s;

    /* renamed from: t  reason: collision with root package name */
    final n f13391t;

    /* renamed from: u  reason: collision with root package name */
    final List f13392u;

    /* renamed from: v  reason: collision with root package name */
    final List f13393v;

    /* renamed from: w  reason: collision with root package name */
    final q f13394w;

    /* renamed from: x  reason: collision with root package name */
    final q f13395x;

    /* renamed from: y  reason: collision with root package name */
    final List f13396y;

    class a extends r {
        a() {
        }

        /* renamed from: e */
        public Double b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return Double.valueOf(aVar.E());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
                return;
            }
            double doubleValue = number.doubleValue();
            d.d(doubleValue);
            cVar.N(doubleValue);
        }
    }

    class b extends r {
        b() {
        }

        /* renamed from: e */
        public Float b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return Float.valueOf((float) aVar.E());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
                return;
            }
            float floatValue = number.floatValue();
            d.d((double) floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            cVar.Q(number);
        }
    }

    class c extends r {
        c() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return Long.valueOf(aVar.H());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
            } else {
                cVar.R(number.toString());
            }
        }
    }

    /* renamed from: y9.d$d  reason: collision with other inner class name */
    class C0162d extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f13399a;

        C0162d(r rVar) {
            this.f13399a = rVar;
        }

        /* renamed from: e */
        public AtomicLong b(ga.a aVar) {
            return new AtomicLong(((Number) this.f13399a.b(aVar)).longValue());
        }

        /* renamed from: f */
        public void d(ga.c cVar, AtomicLong atomicLong) {
            this.f13399a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f13400a;

        e(r rVar) {
            this.f13400a = rVar;
        }

        /* renamed from: e */
        public AtomicLongArray b(ga.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.y()) {
                arrayList.add(Long.valueOf(((Number) this.f13400a.b(aVar)).longValue()));
            }
            aVar.m();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        /* renamed from: f */
        public void d(ga.c cVar, AtomicLongArray atomicLongArray) {
            cVar.h();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f13400a.d(cVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            cVar.m();
        }
    }

    static class f extends k {

        /* renamed from: a  reason: collision with root package name */
        private r f13401a = null;

        f() {
        }

        private r f() {
            r rVar = this.f13401a;
            if (rVar != null) {
                return rVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public Object b(ga.a aVar) {
            return f().b(aVar);
        }

        public void d(ga.c cVar, Object obj) {
            f().d(cVar, obj);
        }

        public r e() {
            return f();
        }

        public void g(r rVar) {
            if (this.f13401a == null) {
                this.f13401a = rVar;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }
    }

    d(aa.d dVar, c cVar, Map map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, n nVar, String str, int i10, int i11, List list, List list2, List list3, q qVar, q qVar2, List list4) {
        Map map2 = map;
        boolean z18 = z11;
        boolean z19 = z16;
        boolean z20 = z17;
        List list5 = list4;
        this.f13377f = dVar;
        this.f13378g = cVar;
        this.f13379h = map2;
        aa.c cVar2 = new aa.c(map2, z20, list5);
        this.f13374c = cVar2;
        this.f13380i = z10;
        this.f13381j = z18;
        this.f13382k = z12;
        this.f13383l = z13;
        this.f13384m = z14;
        this.f13385n = z15;
        this.f13386o = z19;
        this.f13387p = z20;
        this.f13391t = nVar;
        this.f13388q = str;
        this.f13389r = i10;
        this.f13390s = i11;
        this.f13392u = list;
        this.f13393v = list2;
        this.f13394w = qVar;
        this.f13395x = qVar2;
        this.f13396y = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(m.W);
        arrayList.add(i.e(qVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(m.C);
        arrayList.add(m.f2579m);
        arrayList.add(m.f2573g);
        arrayList.add(m.f2575i);
        arrayList.add(m.f2577k);
        r n10 = n(nVar);
        arrayList.add(m.a(Long.TYPE, Long.class, n10));
        arrayList.add(m.a(Double.TYPE, Double.class, e(z19)));
        arrayList.add(m.a(Float.TYPE, Float.class, f(z19)));
        arrayList.add(h.e(qVar2));
        arrayList.add(m.f2581o);
        arrayList.add(m.f2583q);
        arrayList.add(m.b(AtomicLong.class, b(n10)));
        arrayList.add(m.b(AtomicLongArray.class, c(n10)));
        arrayList.add(m.f2585s);
        arrayList.add(m.f2590x);
        arrayList.add(m.E);
        arrayList.add(m.G);
        arrayList.add(m.b(BigDecimal.class, m.f2592z));
        arrayList.add(m.b(BigInteger.class, m.A));
        arrayList.add(m.b(g.class, m.B));
        arrayList.add(m.I);
        arrayList.add(m.K);
        arrayList.add(m.O);
        arrayList.add(m.Q);
        arrayList.add(m.U);
        arrayList.add(m.M);
        arrayList.add(m.f2570d);
        arrayList.add(ba.c.f2517b);
        arrayList.add(m.S);
        if (ea.d.f12060a) {
            arrayList.add(ea.d.f12064e);
            arrayList.add(ea.d.f12063d);
            arrayList.add(ea.d.f12065f);
        }
        arrayList.add(ba.a.f2511c);
        arrayList.add(m.f2568b);
        arrayList.add(new ba.b(cVar2));
        arrayList.add(new ba.g(cVar2, z18));
        ba.e eVar = new ba.e(cVar2);
        this.f13375d = eVar;
        arrayList.add(eVar);
        arrayList.add(m.X);
        arrayList.add(new j(cVar2, cVar, dVar, eVar, list4));
        this.f13376e = Collections.unmodifiableList(arrayList);
    }

    private static void a(Object obj, ga.a aVar) {
        if (obj != null) {
            try {
                if (aVar.O() != ga.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (ga.d e10) {
                throw new m((Throwable) e10);
            } catch (IOException e11) {
                throw new h((Throwable) e11);
            }
        }
    }

    private static r b(r rVar) {
        return new C0162d(rVar).a();
    }

    private static r c(r rVar) {
        return new e(rVar).a();
    }

    static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private r e(boolean z10) {
        if (z10) {
            return m.f2588v;
        }
        return new a();
    }

    private r f(boolean z10) {
        if (z10) {
            return m.f2587u;
        }
        return new b();
    }

    private static r n(n nVar) {
        if (nVar == n.DEFAULT) {
            return m.f2586t;
        }
        return new c();
    }

    public Object g(ga.a aVar, fa.a aVar2) {
        boolean z10 = aVar.z();
        aVar.T(true);
        try {
            aVar.O();
            Object b10 = k(aVar2).b(aVar);
            aVar.T(z10);
            return b10;
        } catch (EOFException e10) {
            if (1 != 0) {
                aVar.T(z10);
                return null;
            }
            throw new m((Throwable) e10);
        } catch (IllegalStateException e11) {
            throw new m((Throwable) e11);
        } catch (IOException e12) {
            throw new m((Throwable) e12);
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e13.getMessage(), e13);
        } catch (Throwable th) {
            aVar.T(z10);
            throw th;
        }
    }

    public Object h(Reader reader, fa.a aVar) {
        ga.a o10 = o(reader);
        Object g10 = g(o10, aVar);
        a(g10, o10);
        return g10;
    }

    public Object i(String str, fa.a aVar) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), aVar);
    }

    public Object j(String str, Type type) {
        return i(str, fa.a.b(type));
    }

    public r k(fa.a aVar) {
        boolean z10;
        Objects.requireNonNull(aVar, "type must not be null");
        r rVar = (r) this.f13373b.get(aVar);
        if (rVar != null) {
            return rVar;
        }
        Map map = (Map) this.f13372a.get();
        if (map == null) {
            map = new HashMap();
            this.f13372a.set(map);
            z10 = true;
        } else {
            r rVar2 = (r) map.get(aVar);
            if (rVar2 != null) {
                return rVar2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator it = this.f13376e.iterator();
            r rVar3 = null;
            while (true) {
                if (it.hasNext()) {
                    rVar3 = ((s) it.next()).a(this, aVar);
                    if (rVar3 != null) {
                        fVar.g(rVar3);
                        map.put(aVar, rVar3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (rVar3 != null) {
                if (z10) {
                    this.f13373b.putAll(map);
                }
                return rVar3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } finally {
            if (z10) {
                this.f13372a.remove();
            }
        }
    }

    public r l(Class cls) {
        return k(fa.a.a(cls));
    }

    public r m(s sVar, fa.a aVar) {
        if (!this.f13376e.contains(sVar)) {
            sVar = this.f13375d;
        }
        boolean z10 = false;
        for (s sVar2 : this.f13376e) {
            if (z10) {
                r a10 = sVar2.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            } else if (sVar2 == sVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public ga.a o(Reader reader) {
        ga.a aVar = new ga.a(reader);
        aVar.T(this.f13385n);
        return aVar;
    }

    public ga.c p(Writer writer) {
        if (this.f13382k) {
            writer.write(")]}'\n");
        }
        ga.c cVar = new ga.c(writer);
        if (this.f13384m) {
            cVar.J("  ");
        }
        cVar.I(this.f13383l);
        cVar.K(this.f13385n);
        cVar.L(this.f13380i);
        return cVar;
    }

    public String q(Object obj) {
        if (obj == null) {
            return s(i.f13423a);
        }
        return r(obj, obj.getClass());
    }

    public String r(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        u(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String s(g gVar) {
        StringWriter stringWriter = new StringWriter();
        w(gVar, stringWriter);
        return stringWriter.toString();
    }

    public void t(Object obj, Type type, ga.c cVar) {
        r k10 = k(fa.a.b(type));
        boolean w10 = cVar.w();
        cVar.K(true);
        boolean v10 = cVar.v();
        cVar.I(this.f13383l);
        boolean p10 = cVar.p();
        cVar.L(this.f13380i);
        try {
            k10.d(cVar, obj);
            cVar.K(w10);
            cVar.I(v10);
            cVar.L(p10);
        } catch (IOException e10) {
            throw new h((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th) {
            cVar.K(w10);
            cVar.I(v10);
            cVar.L(p10);
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f13380i + ",factories:" + this.f13376e + ",instanceCreators:" + this.f13374c + "}";
    }

    public void u(Object obj, Type type, Appendable appendable) {
        try {
            t(obj, type, p(aa.m.b(appendable)));
        } catch (IOException e10) {
            throw new h((Throwable) e10);
        }
    }

    public void v(g gVar, ga.c cVar) {
        boolean w10 = cVar.w();
        cVar.K(true);
        boolean v10 = cVar.v();
        cVar.I(this.f13383l);
        boolean p10 = cVar.p();
        cVar.L(this.f13380i);
        try {
            aa.m.a(gVar, cVar);
            cVar.K(w10);
            cVar.I(v10);
            cVar.L(p10);
        } catch (IOException e10) {
            throw new h((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th) {
            cVar.K(w10);
            cVar.I(v10);
            cVar.L(p10);
            throw th;
        }
    }

    public void w(g gVar, Appendable appendable) {
        try {
            v(gVar, p(aa.m.b(appendable)));
        } catch (IOException e10) {
            throw new h((Throwable) e10);
        }
    }
}
