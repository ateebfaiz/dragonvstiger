package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import java.util.HashMap;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    protected static final HashMap f5529a;

    public static class a extends a {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5530e = o.F().I(Boolean.class);

        public a() {
            super(boolean[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new a(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, boolean[] zArr) {
            if (zArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(boolean[] zArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            int length = zArr.length;
            if (length != 1 || !z(b0Var)) {
                fVar.n0(zArr, length);
                B(zArr, fVar, b0Var);
                fVar.P();
                return;
            }
            B(zArr, fVar, b0Var);
        }

        /* renamed from: E */
        public void B(boolean[] zArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (boolean O : zArr) {
                fVar.O(O);
            }
        }

        public com.fasterxml.jackson.databind.ser.h x(q8.g gVar) {
            return this;
        }

        protected a(a aVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(aVar, dVar, bool);
        }
    }

    public static class b extends h0 {
        public b() {
            super(char[].class);
        }

        private final void x(com.fasterxml.jackson.core.f fVar, char[] cArr) {
            int length = cArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                fVar.t0(cArr, i10, 1);
            }
        }

        /* renamed from: A */
        public void h(char[] cArr, com.fasterxml.jackson.core.f fVar, b0 b0Var, q8.g gVar) {
            i8.b bVar;
            if (b0Var.b0(a0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                bVar = gVar.g(fVar, gVar.d(cArr, k.START_ARRAY));
                x(fVar, cArr);
            } else {
                bVar = gVar.g(fVar, gVar.d(cArr, k.VALUE_STRING));
                fVar.t0(cArr, 0, cArr.length);
            }
            gVar.h(fVar, bVar);
        }

        /* renamed from: y */
        public boolean d(b0 b0Var, char[] cArr) {
            if (cArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: z */
        public void f(char[] cArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            if (b0Var.b0(a0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                fVar.n0(cArr, cArr.length);
                x(fVar, cArr);
                fVar.P();
                return;
            }
            fVar.t0(cArr, 0, cArr.length);
        }
    }

    public static class c extends a {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5531e = o.F().I(Double.TYPE);

        public c() {
            super(double[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new c(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, double[] dArr) {
            if (dArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(double[] dArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            if (dArr.length != 1 || !z(b0Var)) {
                fVar.G(dArr, 0, dArr.length);
            } else {
                B(dArr, fVar, b0Var);
            }
        }

        /* renamed from: E */
        public void B(double[] dArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (double V : dArr) {
                fVar.V(V);
            }
        }

        public com.fasterxml.jackson.databind.ser.h x(q8.g gVar) {
            return this;
        }

        protected c(c cVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(cVar, dVar, bool);
        }
    }

    public static class d extends h {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5532e = o.F().I(Float.TYPE);

        public d() {
            super(float[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new d(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, float[] fArr) {
            if (fArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(float[] fArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            int length = fArr.length;
            if (length != 1 || !z(b0Var)) {
                fVar.n0(fArr, length);
                B(fArr, fVar, b0Var);
                fVar.P();
                return;
            }
            B(fArr, fVar, b0Var);
        }

        /* renamed from: E */
        public void B(float[] fArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (float W : fArr) {
                fVar.W(W);
            }
        }

        public d(d dVar, com.fasterxml.jackson.databind.d dVar2, Boolean bool) {
            super(dVar, dVar2, bool);
        }
    }

    public static class e extends a {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5533e = o.F().I(Integer.TYPE);

        public e() {
            super(int[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new e(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, int[] iArr) {
            if (iArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(int[] iArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            if (iArr.length != 1 || !z(b0Var)) {
                fVar.H(iArr, 0, iArr.length);
            } else {
                B(iArr, fVar, b0Var);
            }
        }

        /* renamed from: E */
        public void B(int[] iArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (int X : iArr) {
                fVar.X(X);
            }
        }

        public com.fasterxml.jackson.databind.ser.h x(q8.g gVar) {
            return this;
        }

        protected e(e eVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(eVar, dVar, bool);
        }
    }

    public static class f extends h {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5534e = o.F().I(Long.TYPE);

        public f() {
            super(long[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new f(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, long[] jArr) {
            if (jArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(long[] jArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            if (jArr.length != 1 || !z(b0Var)) {
                fVar.I(jArr, 0, jArr.length);
            } else {
                B(jArr, fVar, b0Var);
            }
        }

        /* renamed from: E */
        public void B(long[] jArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (long Y : jArr) {
                fVar.Y(Y);
            }
        }

        public f(f fVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(fVar, dVar, bool);
        }
    }

    public static class g extends h {

        /* renamed from: e  reason: collision with root package name */
        private static final j f5535e = o.F().I(Short.TYPE);

        public g() {
            super(short[].class);
        }

        public com.fasterxml.jackson.databind.o A(com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            return new g(this, dVar, bool);
        }

        /* renamed from: C */
        public boolean d(b0 b0Var, short[] sArr) {
            if (sArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: D */
        public final void f(short[] sArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            int length = sArr.length;
            if (length != 1 || !z(b0Var)) {
                fVar.n0(sArr, length);
                B(sArr, fVar, b0Var);
                fVar.P();
                return;
            }
            B(sArr, fVar, b0Var);
        }

        /* renamed from: E */
        public void B(short[] sArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
            for (short X : sArr) {
                fVar.X(X);
            }
        }

        public g(g gVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(gVar, dVar, bool);
        }
    }

    protected static abstract class h extends a {
        protected h(Class cls) {
            super(cls);
        }

        public final com.fasterxml.jackson.databind.ser.h x(q8.g gVar) {
            return this;
        }

        protected h(h hVar, com.fasterxml.jackson.databind.d dVar, Boolean bool) {
            super(hVar, dVar, bool);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f5529a = hashMap;
        hashMap.put(boolean[].class.getName(), new a());
        hashMap.put(byte[].class.getName(), new f());
        hashMap.put(char[].class.getName(), new b());
        hashMap.put(short[].class.getName(), new g());
        hashMap.put(int[].class.getName(), new e());
        hashMap.put(long[].class.getName(), new f());
        hashMap.put(float[].class.getName(), new d());
        hashMap.put(double[].class.getName(), new c());
    }

    public static com.fasterxml.jackson.databind.o a(Class cls) {
        return (com.fasterxml.jackson.databind.o) f5529a.get(cls.getName());
    }
}
