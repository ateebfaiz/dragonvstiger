package ba;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public abstract class m {
    public static final y9.r A = new h();
    public static final y9.r B = new i();
    public static final y9.s C;
    public static final y9.r D;
    public static final y9.s E;
    public static final y9.r F;
    public static final y9.s G;
    public static final y9.r H;
    public static final y9.s I;
    public static final y9.r J;
    public static final y9.s K;
    public static final y9.r L;
    public static final y9.s M;
    public static final y9.r N;
    public static final y9.s O;
    public static final y9.r P;
    public static final y9.s Q;
    public static final y9.r R;
    public static final y9.s S;
    public static final y9.r T;
    public static final y9.s U;
    public static final y9.r V;
    public static final y9.s W;
    public static final y9.s X = new u();

    /* renamed from: a  reason: collision with root package name */
    public static final y9.r f2567a;

    /* renamed from: b  reason: collision with root package name */
    public static final y9.s f2568b;

    /* renamed from: c  reason: collision with root package name */
    public static final y9.r f2569c;

    /* renamed from: d  reason: collision with root package name */
    public static final y9.s f2570d;

    /* renamed from: e  reason: collision with root package name */
    public static final y9.r f2571e;

    /* renamed from: f  reason: collision with root package name */
    public static final y9.r f2572f = new c0();

    /* renamed from: g  reason: collision with root package name */
    public static final y9.s f2573g;

    /* renamed from: h  reason: collision with root package name */
    public static final y9.r f2574h;

    /* renamed from: i  reason: collision with root package name */
    public static final y9.s f2575i;

    /* renamed from: j  reason: collision with root package name */
    public static final y9.r f2576j;

    /* renamed from: k  reason: collision with root package name */
    public static final y9.s f2577k;

    /* renamed from: l  reason: collision with root package name */
    public static final y9.r f2578l;

    /* renamed from: m  reason: collision with root package name */
    public static final y9.s f2579m;

    /* renamed from: n  reason: collision with root package name */
    public static final y9.r f2580n;

    /* renamed from: o  reason: collision with root package name */
    public static final y9.s f2581o;

    /* renamed from: p  reason: collision with root package name */
    public static final y9.r f2582p;

    /* renamed from: q  reason: collision with root package name */
    public static final y9.s f2583q;

    /* renamed from: r  reason: collision with root package name */
    public static final y9.r f2584r;

    /* renamed from: s  reason: collision with root package name */
    public static final y9.s f2585s;

    /* renamed from: t  reason: collision with root package name */
    public static final y9.r f2586t = new b();

    /* renamed from: u  reason: collision with root package name */
    public static final y9.r f2587u = new c();

    /* renamed from: v  reason: collision with root package name */
    public static final y9.r f2588v = new d();

    /* renamed from: w  reason: collision with root package name */
    public static final y9.r f2589w;

    /* renamed from: x  reason: collision with root package name */
    public static final y9.s f2590x;

    /* renamed from: y  reason: collision with root package name */
    public static final y9.r f2591y;

    /* renamed from: z  reason: collision with root package name */
    public static final y9.r f2592z = new g();

    class a extends y9.r {
        a() {
        }

        /* renamed from: e */
        public AtomicIntegerArray b(ga.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.y()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.G()));
                } catch (NumberFormatException e10) {
                    throw new y9.m((Throwable) e10);
                }
            }
            aVar.m();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        /* renamed from: f */
        public void d(ga.c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.h();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.O((long) atomicIntegerArray.get(i10));
            }
            cVar.m();
        }
    }

    static /* synthetic */ class a0 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2593a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                ga.b[] r0 = ga.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2593a = r0
                ga.b r1 = ga.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2593a     // Catch:{ NoSuchFieldError -> 0x001d }
                ga.b r1 = ga.b.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2593a     // Catch:{ NoSuchFieldError -> 0x0028 }
                ga.b r1 = ga.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2593a     // Catch:{ NoSuchFieldError -> 0x0033 }
                ga.b r1 = ga.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2593a     // Catch:{ NoSuchFieldError -> 0x003e }
                ga.b r1 = ga.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2593a     // Catch:{ NoSuchFieldError -> 0x0049 }
                ga.b r1 = ga.b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ba.m.a0.<clinit>():void");
        }
    }

    class b extends y9.r {
        b() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            try {
                return Long.valueOf(aVar.H());
            } catch (NumberFormatException e10) {
                throw new y9.m((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
            } else {
                cVar.O(number.longValue());
            }
        }
    }

    class b0 extends y9.r {
        b0() {
        }

        /* renamed from: e */
        public Boolean b(ga.a aVar) {
            ga.b O = aVar.O();
            if (O == ga.b.NULL) {
                aVar.K();
                return null;
            } else if (O == ga.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.M()));
            } else {
                return Boolean.valueOf(aVar.C());
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Boolean bool) {
            cVar.P(bool);
        }
    }

    class c extends y9.r {
        c() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.Q(number);
        }
    }

    class c0 extends y9.r {
        c0() {
        }

        /* renamed from: e */
        public Boolean b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return Boolean.valueOf(aVar.M());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Boolean bool) {
            String str;
            if (bool == null) {
                str = "null";
            } else {
                str = bool.toString();
            }
            cVar.R(str);
        }
    }

    class d extends y9.r {
        d() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
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
            } else {
                cVar.N(number.doubleValue());
            }
        }
    }

    class d0 extends y9.r {
        d0() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            try {
                int G = aVar.G();
                if (G <= 255 && G >= -128) {
                    return Byte.valueOf((byte) G);
                }
                throw new y9.m("Lossy conversion from " + G + " to byte; at path " + aVar.w());
            } catch (NumberFormatException e10) {
                throw new y9.m((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
            } else {
                cVar.O((long) number.byteValue());
            }
        }
    }

    class e extends y9.r {
        e() {
        }

        /* renamed from: e */
        public Character b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            if (M.length() == 1) {
                return Character.valueOf(M.charAt(0));
            }
            throw new y9.m("Expecting character, got: " + M + "; at " + aVar.w());
        }

        /* renamed from: f */
        public void d(ga.c cVar, Character ch) {
            String str;
            if (ch == null) {
                str = null;
            } else {
                str = String.valueOf(ch);
            }
            cVar.R(str);
        }
    }

    class e0 extends y9.r {
        e0() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            try {
                int G = aVar.G();
                if (G <= 65535 && G >= -32768) {
                    return Short.valueOf((short) G);
                }
                throw new y9.m("Lossy conversion from " + G + " to short; at path " + aVar.w());
            } catch (NumberFormatException e10) {
                throw new y9.m((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
            } else {
                cVar.O((long) number.shortValue());
            }
        }
    }

    class f extends y9.r {
        f() {
        }

        /* renamed from: e */
        public String b(ga.a aVar) {
            ga.b O = aVar.O();
            if (O == ga.b.NULL) {
                aVar.K();
                return null;
            } else if (O == ga.b.BOOLEAN) {
                return Boolean.toString(aVar.C());
            } else {
                return aVar.M();
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, String str) {
            cVar.R(str);
        }
    }

    class f0 extends y9.r {
        f0() {
        }

        /* renamed from: e */
        public Number b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            try {
                return Integer.valueOf(aVar.G());
            } catch (NumberFormatException e10) {
                throw new y9.m((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Number number) {
            if (number == null) {
                cVar.B();
            } else {
                cVar.O((long) number.intValue());
            }
        }
    }

    class g extends y9.r {
        g() {
        }

        /* renamed from: e */
        public BigDecimal b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            try {
                return new BigDecimal(M);
            } catch (NumberFormatException e10) {
                throw new y9.m("Failed parsing '" + M + "' as BigDecimal; at path " + aVar.w(), e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, BigDecimal bigDecimal) {
            cVar.Q(bigDecimal);
        }
    }

    class g0 extends y9.r {
        g0() {
        }

        /* renamed from: e */
        public AtomicInteger b(ga.a aVar) {
            try {
                return new AtomicInteger(aVar.G());
            } catch (NumberFormatException e10) {
                throw new y9.m((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, AtomicInteger atomicInteger) {
            cVar.O((long) atomicInteger.get());
        }
    }

    class h extends y9.r {
        h() {
        }

        /* renamed from: e */
        public BigInteger b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            try {
                return new BigInteger(M);
            } catch (NumberFormatException e10) {
                throw new y9.m("Failed parsing '" + M + "' as BigInteger; at path " + aVar.w(), e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, BigInteger bigInteger) {
            cVar.Q(bigInteger);
        }
    }

    class h0 extends y9.r {
        h0() {
        }

        /* renamed from: e */
        public AtomicBoolean b(ga.a aVar) {
            return new AtomicBoolean(aVar.C());
        }

        /* renamed from: f */
        public void d(ga.c cVar, AtomicBoolean atomicBoolean) {
            cVar.S(atomicBoolean.get());
        }
    }

    class i extends y9.r {
        i() {
        }

        /* renamed from: e */
        public aa.g b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return new aa.g(aVar.M());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, aa.g gVar) {
            cVar.Q(gVar);
        }
    }

    private static final class i0 extends y9.r {

        /* renamed from: a  reason: collision with root package name */
        private final Map f2594a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f2595b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map f2596c = new HashMap();

        class a implements PrivilegedAction {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f2597a;

            a(Class cls) {
                this.f2597a = cls;
            }

            /* renamed from: a */
            public Field[] run() {
                Field[] declaredFields = this.f2597a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public i0(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum enumR = (Enum) field.get((Object) null);
                    String name = enumR.name();
                    String str = enumR.toString();
                    z9.c cVar = (z9.c) field.getAnnotation(z9.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String put : cVar.alternate()) {
                            this.f2594a.put(put, enumR);
                        }
                    }
                    this.f2594a.put(name, enumR);
                    this.f2595b.put(str, enumR);
                    this.f2596c.put(enumR, name);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        /* renamed from: e */
        public Enum b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            Enum enumR = (Enum) this.f2594a.get(M);
            if (enumR == null) {
                return (Enum) this.f2595b.get(M);
            }
            return enumR;
        }

        /* renamed from: f */
        public void d(ga.c cVar, Enum enumR) {
            String str;
            if (enumR == null) {
                str = null;
            } else {
                str = (String) this.f2596c.get(enumR);
            }
            cVar.R(str);
        }
    }

    class j extends y9.r {
        j() {
        }

        /* renamed from: e */
        public StringBuilder b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return new StringBuilder(aVar.M());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, StringBuilder sb2) {
            String str;
            if (sb2 == null) {
                str = null;
            } else {
                str = sb2.toString();
            }
            cVar.R(str);
        }
    }

    class k extends y9.r {
        k() {
        }

        /* renamed from: e */
        public Class b(ga.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        /* renamed from: f */
        public void d(ga.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends y9.r {
        l() {
        }

        /* renamed from: e */
        public StringBuffer b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return new StringBuffer(aVar.M());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, StringBuffer stringBuffer) {
            String str;
            if (stringBuffer == null) {
                str = null;
            } else {
                str = stringBuffer.toString();
            }
            cVar.R(str);
        }
    }

    /* renamed from: ba.m$m  reason: collision with other inner class name */
    class C0043m extends y9.r {
        C0043m() {
        }

        /* renamed from: e */
        public URL b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            if ("null".equals(M)) {
                return null;
            }
            return new URL(M);
        }

        /* renamed from: f */
        public void d(ga.c cVar, URL url) {
            String str;
            if (url == null) {
                str = null;
            } else {
                str = url.toExternalForm();
            }
            cVar.R(str);
        }
    }

    class n extends y9.r {
        n() {
        }

        /* renamed from: e */
        public URI b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            try {
                String M = aVar.M();
                if ("null".equals(M)) {
                    return null;
                }
                return new URI(M);
            } catch (URISyntaxException e10) {
                throw new y9.h((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, URI uri) {
            String str;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toASCIIString();
            }
            cVar.R(str);
        }
    }

    class o extends y9.r {
        o() {
        }

        /* renamed from: e */
        public InetAddress b(ga.a aVar) {
            if (aVar.O() != ga.b.NULL) {
                return InetAddress.getByName(aVar.M());
            }
            aVar.K();
            return null;
        }

        /* renamed from: f */
        public void d(ga.c cVar, InetAddress inetAddress) {
            String str;
            if (inetAddress == null) {
                str = null;
            } else {
                str = inetAddress.getHostAddress();
            }
            cVar.R(str);
        }
    }

    class p extends y9.r {
        p() {
        }

        /* renamed from: e */
        public UUID b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            String M = aVar.M();
            try {
                return UUID.fromString(M);
            } catch (IllegalArgumentException e10) {
                throw new y9.m("Failed parsing '" + M + "' as UUID; at path " + aVar.w(), e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, UUID uuid) {
            String str;
            if (uuid == null) {
                str = null;
            } else {
                str = uuid.toString();
            }
            cVar.R(str);
        }
    }

    class q extends y9.r {
        q() {
        }

        /* renamed from: e */
        public Currency b(ga.a aVar) {
            String M = aVar.M();
            try {
                return Currency.getInstance(M);
            } catch (IllegalArgumentException e10) {
                throw new y9.m("Failed parsing '" + M + "' as Currency; at path " + aVar.w(), e10);
            }
        }

        /* renamed from: f */
        public void d(ga.c cVar, Currency currency) {
            cVar.R(currency.getCurrencyCode());
        }
    }

    class r extends y9.r {
        r() {
        }

        /* renamed from: e */
        public Calendar b(ga.a aVar) {
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            aVar.b();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.O() != ga.b.END_OBJECT) {
                String I = aVar.I();
                int G = aVar.G();
                if ("year".equals(I)) {
                    i10 = G;
                } else if ("month".equals(I)) {
                    i11 = G;
                } else if ("dayOfMonth".equals(I)) {
                    i12 = G;
                } else if ("hourOfDay".equals(I)) {
                    i13 = G;
                } else if ("minute".equals(I)) {
                    i14 = G;
                } else if ("second".equals(I)) {
                    i15 = G;
                }
            }
            aVar.n();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        /* renamed from: f */
        public void d(ga.c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.B();
                return;
            }
            cVar.j();
            cVar.z("year");
            cVar.O((long) calendar.get(1));
            cVar.z("month");
            cVar.O((long) calendar.get(2));
            cVar.z("dayOfMonth");
            cVar.O((long) calendar.get(5));
            cVar.z("hourOfDay");
            cVar.O((long) calendar.get(11));
            cVar.z("minute");
            cVar.O((long) calendar.get(12));
            cVar.z("second");
            cVar.O((long) calendar.get(13));
            cVar.n();
        }
    }

    class s extends y9.r {
        s() {
        }

        /* renamed from: e */
        public Locale b(ga.a aVar) {
            String str;
            String str2;
            String str3 = null;
            if (aVar.O() == ga.b.NULL) {
                aVar.K();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.M(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        /* renamed from: f */
        public void d(ga.c cVar, Locale locale) {
            String str;
            if (locale == null) {
                str = null;
            } else {
                str = locale.toString();
            }
            cVar.R(str);
        }
    }

    class t extends y9.r {
        t() {
        }

        private y9.g f(ga.a aVar, ga.b bVar) {
            int i10 = a0.f2593a[bVar.ordinal()];
            if (i10 == 1) {
                return new y9.l((Number) new aa.g(aVar.M()));
            }
            if (i10 == 2) {
                return new y9.l(aVar.M());
            }
            if (i10 == 3) {
                return new y9.l(Boolean.valueOf(aVar.C()));
            }
            if (i10 == 6) {
                aVar.K();
                return y9.i.f13423a;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        private y9.g g(ga.a aVar, ga.b bVar) {
            int i10 = a0.f2593a[bVar.ordinal()];
            if (i10 == 4) {
                aVar.a();
                return new y9.f();
            } else if (i10 != 5) {
                return null;
            } else {
                aVar.b();
                return new y9.j();
            }
        }

        /* renamed from: e */
        public y9.g b(ga.a aVar) {
            String str;
            boolean z10;
            ga.b O = aVar.O();
            y9.g g10 = g(aVar, O);
            if (g10 == null) {
                return f(aVar, O);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.y()) {
                    if (g10 instanceof y9.j) {
                        str = aVar.I();
                    } else {
                        str = null;
                    }
                    ga.b O2 = aVar.O();
                    y9.g g11 = g(aVar, O2);
                    if (g11 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (g11 == null) {
                        g11 = f(aVar, O2);
                    }
                    if (g10 instanceof y9.f) {
                        ((y9.f) g10).j(g11);
                    } else {
                        ((y9.j) g10).j(str, g11);
                    }
                    if (z10) {
                        arrayDeque.addLast(g10);
                        g10 = g11;
                    }
                } else {
                    if (g10 instanceof y9.f) {
                        aVar.m();
                    } else {
                        aVar.n();
                    }
                    if (arrayDeque.isEmpty()) {
                        return g10;
                    }
                    g10 = (y9.g) arrayDeque.removeLast();
                }
            }
        }

        /* renamed from: h */
        public void d(ga.c cVar, y9.g gVar) {
            if (gVar == null || gVar.f()) {
                cVar.B();
            } else if (gVar.i()) {
                y9.l d10 = gVar.d();
                if (d10.o()) {
                    cVar.Q(d10.k());
                } else if (d10.m()) {
                    cVar.S(d10.j());
                } else {
                    cVar.R(d10.l());
                }
            } else if (gVar.e()) {
                cVar.h();
                Iterator it = gVar.a().iterator();
                while (it.hasNext()) {
                    d(cVar, (y9.g) it.next());
                }
                cVar.m();
            } else if (gVar.g()) {
                cVar.j();
                for (Map.Entry entry : gVar.c().k()) {
                    cVar.z((String) entry.getKey());
                    d(cVar, (y9.g) entry.getValue());
                }
                cVar.n();
            } else {
                throw new IllegalArgumentException("Couldn't write " + gVar.getClass());
            }
        }
    }

    class u implements y9.s {
        u() {
        }

        public y9.r a(y9.d dVar, fa.a aVar) {
            Class<? super Enum> d10 = aVar.d();
            Class<Enum> cls = Enum.class;
            if (!cls.isAssignableFrom(d10) || d10 == cls) {
                return null;
            }
            if (!d10.isEnum()) {
                d10 = d10.getSuperclass();
            }
            return new i0(d10);
        }
    }

    class v extends y9.r {
        v() {
        }

        /* renamed from: e */
        public BitSet b(ga.a aVar) {
            BitSet bitSet = new BitSet();
            aVar.a();
            ga.b O = aVar.O();
            int i10 = 0;
            while (O != ga.b.END_ARRAY) {
                int i11 = a0.f2593a[O.ordinal()];
                boolean z10 = true;
                if (i11 == 1 || i11 == 2) {
                    int G = aVar.G();
                    if (G == 0) {
                        z10 = false;
                    } else if (G != 1) {
                        throw new y9.m("Invalid bitset value " + G + ", expected 0 or 1; at path " + aVar.w());
                    }
                } else if (i11 == 3) {
                    z10 = aVar.C();
                } else {
                    throw new y9.m("Invalid bitset value type: " + O + "; at path " + aVar.getPath());
                }
                if (z10) {
                    bitSet.set(i10);
                }
                i10++;
                O = aVar.O();
            }
            aVar.m();
            return bitSet;
        }

        /* renamed from: f */
        public void d(ga.c cVar, BitSet bitSet) {
            cVar.h();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.O(bitSet.get(i10) ? 1 : 0);
            }
            cVar.m();
        }
    }

    class w implements y9.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2599a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y9.r f2600b;

        w(Class cls, y9.r rVar) {
            this.f2599a = cls;
            this.f2600b = rVar;
        }

        public y9.r a(y9.d dVar, fa.a aVar) {
            if (aVar.d() == this.f2599a) {
                return this.f2600b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f2599a.getName() + ",adapter=" + this.f2600b + "]";
        }
    }

    class x implements y9.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2601a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f2602b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y9.r f2603c;

        x(Class cls, Class cls2, y9.r rVar) {
            this.f2601a = cls;
            this.f2602b = cls2;
            this.f2603c = rVar;
        }

        public y9.r a(y9.d dVar, fa.a aVar) {
            Class d10 = aVar.d();
            if (d10 == this.f2601a || d10 == this.f2602b) {
                return this.f2603c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f2602b.getName() + "+" + this.f2601a.getName() + ",adapter=" + this.f2603c + "]";
        }
    }

    class y implements y9.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2604a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f2605b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y9.r f2606c;

        y(Class cls, Class cls2, y9.r rVar) {
            this.f2604a = cls;
            this.f2605b = cls2;
            this.f2606c = rVar;
        }

        public y9.r a(y9.d dVar, fa.a aVar) {
            Class d10 = aVar.d();
            if (d10 == this.f2604a || d10 == this.f2605b) {
                return this.f2606c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f2604a.getName() + "+" + this.f2605b.getName() + ",adapter=" + this.f2606c + "]";
        }
    }

    class z implements y9.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f2607a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y9.r f2608b;

        class a extends y9.r {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f2609a;

            a(Class cls) {
                this.f2609a = cls;
            }

            public Object b(ga.a aVar) {
                Object b10 = z.this.f2608b.b(aVar);
                if (b10 == null || this.f2609a.isInstance(b10)) {
                    return b10;
                }
                throw new y9.m("Expected a " + this.f2609a.getName() + " but was " + b10.getClass().getName() + "; at path " + aVar.w());
            }

            public void d(ga.c cVar, Object obj) {
                z.this.f2608b.d(cVar, obj);
            }
        }

        z(Class cls, y9.r rVar) {
            this.f2607a = cls;
            this.f2608b = rVar;
        }

        public y9.r a(y9.d dVar, fa.a aVar) {
            Class d10 = aVar.d();
            if (!this.f2607a.isAssignableFrom(d10)) {
                return null;
            }
            return new a(d10);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f2607a.getName() + ",adapter=" + this.f2608b + "]";
        }
    }

    static {
        y9.r a10 = new k().a();
        f2567a = a10;
        f2568b = b(Class.class, a10);
        y9.r a11 = new v().a();
        f2569c = a11;
        f2570d = b(BitSet.class, a11);
        b0 b0Var = new b0();
        f2571e = b0Var;
        f2573g = a(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f2574h = d0Var;
        f2575i = a(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f2576j = e0Var;
        f2577k = a(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        f2578l = f0Var;
        f2579m = a(Integer.TYPE, Integer.class, f0Var);
        y9.r a12 = new g0().a();
        f2580n = a12;
        f2581o = b(AtomicInteger.class, a12);
        y9.r a13 = new h0().a();
        f2582p = a13;
        f2583q = b(AtomicBoolean.class, a13);
        y9.r a14 = new a().a();
        f2584r = a14;
        f2585s = b(AtomicIntegerArray.class, a14);
        e eVar = new e();
        f2589w = eVar;
        f2590x = a(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f2591y = fVar;
        C = b(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = b(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = b(StringBuffer.class, lVar);
        C0043m mVar = new C0043m();
        H = mVar;
        I = b(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = b(URI.class, nVar);
        o oVar = new o();
        L = oVar;
        M = d(InetAddress.class, oVar);
        p pVar = new p();
        N = pVar;
        O = b(UUID.class, pVar);
        y9.r a15 = new q().a();
        P = a15;
        Q = b(Currency.class, a15);
        r rVar = new r();
        R = rVar;
        S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = b(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = d(y9.g.class, tVar);
    }

    public static y9.s a(Class cls, Class cls2, y9.r rVar) {
        return new x(cls, cls2, rVar);
    }

    public static y9.s b(Class cls, y9.r rVar) {
        return new w(cls, rVar);
    }

    public static y9.s c(Class cls, Class cls2, y9.r rVar) {
        return new y(cls, cls2, rVar);
    }

    public static y9.s d(Class cls, y9.r rVar) {
        return new z(cls, rVar);
    }
}
