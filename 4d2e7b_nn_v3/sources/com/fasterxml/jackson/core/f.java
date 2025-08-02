package com.fasterxml.jackson.core;

import i8.b;
import j8.h;
import j8.l;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class f implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    protected static final h f5091b;

    /* renamed from: c  reason: collision with root package name */
    protected static final h f5092c;

    /* renamed from: d  reason: collision with root package name */
    protected static final h f5093d;

    /* renamed from: a  reason: collision with root package name */
    protected m f5094a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5095a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                i8.b$a[] r0 = i8.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5095a = r0
                i8.b$a r1 = i8.b.a.PARENT_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5095a     // Catch:{ NoSuchFieldError -> 0x001d }
                i8.b$a r1 = i8.b.a.PAYLOAD_PROPERTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5095a     // Catch:{ NoSuchFieldError -> 0x0028 }
                i8.b$a r1 = i8.b.a.METADATA_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5095a     // Catch:{ NoSuchFieldError -> 0x0033 }
                i8.b$a r1 = i8.b.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5095a     // Catch:{ NoSuchFieldError -> 0x003e }
                i8.b$a r1 = i8.b.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.f.a.<clinit>():void");
        }
    }

    public enum b {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);
        

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5105a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5106b;

        private b(boolean z10) {
            this.f5105a = z10;
            this.f5106b = 1 << ordinal();
        }

        public static int a() {
            int i10 = 0;
            for (b bVar : values()) {
                if (bVar.b()) {
                    i10 |= bVar.d();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f5105a;
        }

        public boolean c(int i10) {
            if ((i10 & this.f5106b) != 0) {
                return true;
            }
            return false;
        }

        public int d() {
            return this.f5106b;
        }
    }

    static {
        h a10 = h.a(o.values());
        f5091b = a10;
        f5092c = a10.b(o.CAN_WRITE_FORMATTED_NUMBERS);
        f5093d = a10.b(o.CAN_WRITE_BINARY_NATIVELY);
    }

    protected f() {
    }

    public abstract f A(int i10, int i11);

    public abstract void B(Object obj);

    public abstract f C(int i10);

    public f E(m mVar) {
        this.f5094a = mVar;
        return this;
    }

    public void G(double[] dArr, int i10, int i11) {
        if (dArr != null) {
            h(dArr.length, i10, i11);
            n0(dArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                V(dArr[i10]);
                i10++;
            }
            P();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public void H(int[] iArr, int i10, int i11) {
        if (iArr != null) {
            h(iArr.length, i10, i11);
            n0(iArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                X(iArr[i10]);
                i10++;
            }
            P();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public void I(long[] jArr, int i10, int i11) {
        if (jArr != null) {
            h(jArr.length, i10, i11);
            n0(jArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                Y(jArr[i10]);
                i10++;
            }
            P();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public abstract int J(a aVar, InputStream inputStream, int i10);

    public int K(InputStream inputStream, int i10) {
        return J(b.a(), inputStream, i10);
    }

    public abstract void L(a aVar, byte[] bArr, int i10, int i11);

    public void M(byte[] bArr) {
        L(b.a(), bArr, 0, bArr.length);
    }

    public void N(byte[] bArr, int i10, int i11) {
        L(b.a(), bArr, i10, i11);
    }

    public abstract void O(boolean z10);

    public abstract void P();

    public abstract void Q();

    public void R(long j10) {
        T(Long.toString(j10));
    }

    public abstract void S(n nVar);

    public abstract void T(String str);

    public abstract void U();

    public abstract void V(double d10);

    public abstract void W(float f10);

    public abstract void X(int i10);

    public abstract void Y(long j10);

    public abstract void Z(String str);

    /* access modifiers changed from: protected */
    public void a(String str) {
        throw new e(str, this);
    }

    public abstract void a0(BigDecimal bigDecimal);

    /* access modifiers changed from: protected */
    public final void b() {
        l.a();
    }

    public abstract void b0(BigInteger bigInteger);

    public abstract void c0(short s10);

    public abstract void close();

    public void d0(Object obj) {
        throw new e("No native support for writing Object Ids", this);
    }

    public void e0(Object obj) {
        throw new e("No native support for writing Object Ids", this);
    }

    public void f0(String str) {
    }

    public abstract void g0(char c10);

    /* access modifiers changed from: protected */
    public final void h(int i10, int i11, int i12) {
        if (i11 < 0 || i11 + i12 > i10) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i10)}));
        }
    }

    public abstract void h0(n nVar);

    public abstract void i0(String str);

    public boolean j() {
        return true;
    }

    public abstract void j0(char[] cArr, int i10, int i11);

    public boolean k() {
        return false;
    }

    public abstract void k0(String str);

    public abstract void l0();

    public boolean m() {
        return false;
    }

    public abstract void m0(Object obj);

    public boolean n() {
        return false;
    }

    public abstract void n0(Object obj, int i10);

    public abstract void o0();

    public abstract f p(b bVar);

    public abstract void p0(Object obj);

    public void q0(Object obj, int i10) {
        o0();
        B(obj);
    }

    public abstract void r0(n nVar);

    public abstract void s0(String str);

    public abstract void t0(char[] cArr, int i10, int i11);

    public void u0(String str, String str2) {
        T(str);
        s0(str2);
    }

    public abstract j v();

    public void v0(Object obj) {
        throw new e("No native support for writing Type Ids", this);
    }

    public m w() {
        return this.f5094a;
    }

    public i8.b w0(i8.b bVar) {
        String str;
        Object obj = bVar.f12332c;
        k kVar = bVar.f12335f;
        if (n()) {
            bVar.f12336g = false;
            v0(obj);
        } else {
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = String.valueOf(obj);
            }
            bVar.f12336g = true;
            b.a aVar = bVar.f12334e;
            if (kVar != k.START_OBJECT && aVar.a()) {
                aVar = b.a.WRAPPER_ARRAY;
                bVar.f12334e = aVar;
            }
            int i10 = a.f5095a[aVar.ordinal()];
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    p0(bVar.f12330a);
                    u0(bVar.f12333d, str);
                    return bVar;
                } else if (i10 != 4) {
                    l0();
                    s0(str);
                } else {
                    o0();
                    T(str);
                }
            }
        }
        if (kVar == k.START_OBJECT) {
            p0(bVar.f12330a);
        } else if (kVar == k.START_ARRAY) {
            l0();
        }
        return bVar;
    }

    public i8.b x0(i8.b bVar) {
        String str;
        k kVar = bVar.f12335f;
        if (kVar == k.START_OBJECT) {
            Q();
        } else if (kVar == k.START_ARRAY) {
            P();
        }
        if (bVar.f12336g) {
            int i10 = a.f5095a[bVar.f12334e.ordinal()];
            if (i10 == 1) {
                Object obj = bVar.f12332c;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = String.valueOf(obj);
                }
                u0(bVar.f12333d, str);
            } else if (!(i10 == 2 || i10 == 3)) {
                if (i10 != 5) {
                    Q();
                } else {
                    P();
                }
            }
        }
        return bVar;
    }

    public abstract boolean y(b bVar);

    public f z(int i10, int i11) {
        return this;
    }
}
