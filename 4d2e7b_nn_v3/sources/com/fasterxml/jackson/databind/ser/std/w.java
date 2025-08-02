package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.o;
import java.math.BigDecimal;
import java.util.Map;

public abstract class w {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5590a;

        static {
            int[] iArr = new int[i.c.values().length];
            f5590a = iArr;
            try {
                iArr[i.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static abstract class b extends g0 implements com.fasterxml.jackson.databind.ser.i {

        /* renamed from: c  reason: collision with root package name */
        protected final h.b f5591c;

        /* renamed from: d  reason: collision with root package name */
        protected final String f5592d;

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f5593e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected b(Class cls, h.b bVar, String str) {
            super(cls, false);
            boolean z10 = false;
            this.f5591c = bVar;
            this.f5592d = str;
            this.f5593e = (bVar == h.b.INT || bVar == h.b.LONG || bVar == h.b.BIG_INTEGER) ? true : z10;
        }

        public o a(b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
            i.d q10 = q(b0Var, dVar, c());
            if (q10 == null || a.f5590a[q10.i().ordinal()] != 1) {
                return this;
            }
            if (c() == BigDecimal.class) {
                return v.x();
            }
            return l0.f5560c;
        }
    }

    public static class c extends b {
        public c(Class cls) {
            super(cls, h.b.DOUBLE, "number");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.V(((Double) obj).doubleValue());
        }

        public void h(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var, q8.g gVar) {
            Double d10 = (Double) obj;
            if (com.fasterxml.jackson.core.io.f.h(d10.doubleValue())) {
                i8.b g10 = gVar.g(fVar, gVar.d(obj, k.VALUE_NUMBER_FLOAT));
                fVar.V(d10.doubleValue());
                gVar.h(fVar, g10);
                return;
            }
            fVar.V(d10.doubleValue());
        }
    }

    public static class d extends b {

        /* renamed from: f  reason: collision with root package name */
        static final d f5594f = new d();

        public d() {
            super(Float.class, h.b.FLOAT, "number");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.W(((Float) obj).floatValue());
        }
    }

    public static class e extends b {

        /* renamed from: f  reason: collision with root package name */
        static final e f5595f = new e();

        public e() {
            super(Number.class, h.b.INT, "integer");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.X(((Number) obj).intValue());
        }
    }

    public static class f extends b {
        public f(Class cls) {
            super(cls, h.b.INT, "integer");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.X(((Integer) obj).intValue());
        }

        public void h(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var, q8.g gVar) {
            f(obj, fVar, b0Var);
        }
    }

    public static class g extends b {
        public g(Class cls) {
            super(cls, h.b.LONG, "number");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.Y(((Long) obj).longValue());
        }
    }

    public static class h extends b {

        /* renamed from: f  reason: collision with root package name */
        static final h f5596f = new h();

        public h() {
            super(Short.class, h.b.INT, "number");
        }

        public void f(Object obj, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            fVar.c0(((Short) obj).shortValue());
        }
    }

    public static void a(Map map) {
        Class<Integer> cls = Integer.class;
        map.put(cls.getName(), new f(cls));
        Class cls2 = Integer.TYPE;
        map.put(cls2.getName(), new f(cls2));
        Class<Long> cls3 = Long.class;
        map.put(cls3.getName(), new g(cls3));
        Class cls4 = Long.TYPE;
        map.put(cls4.getName(), new g(cls4));
        String name = Byte.class.getName();
        e eVar = e.f5595f;
        map.put(name, eVar);
        map.put(Byte.TYPE.getName(), eVar);
        String name2 = Short.class.getName();
        h hVar = h.f5596f;
        map.put(name2, hVar);
        map.put(Short.TYPE.getName(), hVar);
        Class<Double> cls5 = Double.class;
        map.put(cls5.getName(), new c(cls5));
        Class cls6 = Double.TYPE;
        map.put(cls6.getName(), new c(cls6));
        String name3 = Float.class.getName();
        d dVar = d.f5594f;
        map.put(name3, dVar);
        map.put(Float.TYPE.getName(), dVar);
    }
}
