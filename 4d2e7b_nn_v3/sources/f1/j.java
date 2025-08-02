package f1;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import okio.Utf8;

public final class j {
    private static final Charset A = Charset.forName("UTF-8");
    private static final EOFException B = new c();

    /* renamed from: z  reason: collision with root package name */
    private static final boolean[] f21402z;

    /* renamed from: a  reason: collision with root package name */
    private int f21403a;

    /* renamed from: b  reason: collision with root package name */
    private int f21404b;

    /* renamed from: c  reason: collision with root package name */
    private long f21405c;

    /* renamed from: d  reason: collision with root package name */
    private byte f21406d;

    /* renamed from: e  reason: collision with root package name */
    private int f21407e;

    /* renamed from: f  reason: collision with root package name */
    private final char[] f21408f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f21409g;

    /* renamed from: h  reason: collision with root package name */
    protected byte[] f21410h;

    /* renamed from: i  reason: collision with root package name */
    protected char[] f21411i;

    /* renamed from: j  reason: collision with root package name */
    private InputStream f21412j;

    /* renamed from: k  reason: collision with root package name */
    private int f21413k;

    /* renamed from: l  reason: collision with root package name */
    private int f21414l;

    /* renamed from: m  reason: collision with root package name */
    private final q f21415m;

    /* renamed from: n  reason: collision with root package name */
    private final q f21416n;

    /* renamed from: o  reason: collision with root package name */
    private final s f21417o;

    /* renamed from: p  reason: collision with root package name */
    private final byte[] f21418p;

    /* renamed from: q  reason: collision with root package name */
    private final int f21419q;

    /* renamed from: r  reason: collision with root package name */
    protected final d f21420r;

    /* renamed from: s  reason: collision with root package name */
    protected final b f21421s;

    /* renamed from: t  reason: collision with root package name */
    protected final int f21422t;

    /* renamed from: u  reason: collision with root package name */
    protected final g f21423u;

    /* renamed from: v  reason: collision with root package name */
    protected final int f21424v;

    /* renamed from: w  reason: collision with root package name */
    private final int f21425w;

    /* renamed from: x  reason: collision with root package name */
    private final StringBuilder f21426x;

    /* renamed from: y  reason: collision with root package name */
    private final Formatter f21427y;

    public enum b {
        EXACT(0),
        HIGH(1),
        DEFAULT(3),
        LOW(4);
        

        /* renamed from: a  reason: collision with root package name */
        final int f21433a;

        private b(int i10) {
            this.f21433a = i10;
        }
    }

    private static class c extends EOFException {
        private c() {
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public enum d {
        WITH_STACK_TRACE,
        DESCRIPTION_AND_POSITION,
        DESCRIPTION_ONLY,
        MINIMAL
    }

    public interface e {
    }

    public interface f {
        Object a(j jVar);
    }

    public enum g {
        LONG_AND_BIGDECIMAL,
        LONG_AND_DOUBLE,
        BIGDECIMAL,
        DOUBLE
    }

    static {
        boolean[] zArr = new boolean[256];
        f21402z = zArr;
        zArr[137] = true;
        zArr[138] = true;
        zArr[139] = true;
        zArr[140] = true;
        zArr[141] = true;
        zArr[160] = true;
        zArr[32] = true;
        zArr[97] = true;
        zArr[98] = true;
        zArr[99] = true;
    }

    private j(char[] cArr, byte[] bArr, int i10, Object obj, q qVar, q qVar2, s sVar, d dVar, b bVar, g gVar, int i11, int i12) {
        this.f21404b = 0;
        this.f21405c = 0;
        this.f21406d = 32;
        StringBuilder sb2 = new StringBuilder(0);
        this.f21426x = sb2;
        this.f21427y = new Formatter(sb2);
        this.f21408f = cArr;
        this.f21410h = bArr;
        this.f21407e = i10;
        int length = bArr.length - 38;
        this.f21414l = length;
        this.f21409g = obj;
        this.f21411i = cArr;
        this.f21415m = qVar;
        this.f21416n = qVar2;
        this.f21417o = sVar;
        this.f21420r = dVar;
        this.f21421s = bVar;
        this.f21423u = gVar;
        this.f21424v = i11;
        this.f21425w = i12;
        this.f21422t = bVar.f21433a + 15;
        this.f21418p = bArr;
        this.f21419q = length;
    }

    private static int C(byte[] bArr, InputStream inputStream, int i10) {
        int read;
        while (i10 < bArr.length && (read = inputStream.read(bArr, i10, bArr.length - i10)) != -1) {
            i10 += read;
        }
        return i10;
    }

    private boolean M() {
        byte b10 = this.f21406d;
        if (!(b10 == -96 || b10 == 32)) {
            switch (b10) {
                case -31:
                    int i10 = this.f21404b;
                    if (i10 + 1 < this.f21407e) {
                        byte[] bArr = this.f21410h;
                        if (bArr[i10] == -102 && bArr[i10 + 1] == Byte.MIN_VALUE) {
                            this.f21404b = i10 + 2;
                            this.f21406d = 32;
                            return true;
                        }
                    }
                    return false;
                case -30:
                    int i11 = this.f21404b;
                    if (i11 + 1 >= this.f21407e) {
                        return false;
                    }
                    byte[] bArr2 = this.f21410h;
                    byte b11 = bArr2[i11];
                    byte b12 = bArr2[i11 + 1];
                    if (b11 == -127 && b12 == -97) {
                        this.f21404b = i11 + 2;
                        this.f21406d = 32;
                        return true;
                    } else if (b11 != Byte.MIN_VALUE) {
                        return false;
                    } else {
                        if (!(b12 == -88 || b12 == -87 || b12 == -81)) {
                            switch (b12) {
                                case Byte.MIN_VALUE:
                                case -127:
                                case -126:
                                case -125:
                                case -124:
                                case -123:
                                case -122:
                                case -121:
                                case -120:
                                case -119:
                                case -118:
                                    break;
                                default:
                                    return false;
                            }
                        }
                        this.f21404b = i11 + 2;
                        this.f21406d = 32;
                        return true;
                    }
                case -29:
                    int i12 = this.f21404b;
                    if (i12 + 1 < this.f21407e) {
                        byte[] bArr3 = this.f21410h;
                        if (bArr3[i12] == Byte.MIN_VALUE && bArr3[i12 + 1] == Byte.MIN_VALUE) {
                            this.f21404b = i12 + 2;
                            this.f21406d = 32;
                            return true;
                        }
                    }
                    return false;
                default:
                    switch (b10) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    private int j(byte b10) {
        if (b10 >= 48 && b10 <= 57) {
            return b10 - 48;
        }
        if (b10 >= 65 && b10 <= 70) {
            return b10 - 55;
        }
        if (b10 >= 97 && b10 <= 102) {
            return b10 - 87;
        }
        throw t("Could not parse unicode escape, expected a hexadecimal digit", Byte.valueOf(b10));
    }

    private void v(int i10, StringBuilder sb2) {
        sb2.append("at position: ");
        sb2.append(w(i10));
        int i11 = this.f21404b;
        if (i11 > i10) {
            try {
                int min = Math.min(i11 - i10, 20);
                String str = new String(this.f21410h, (this.f21404b - i10) - min, min, A);
                sb2.append(", following: `");
                sb2.append(str);
                sb2.append('`');
            } catch (Exception unused) {
            }
        }
        int i12 = this.f21404b;
        int i13 = i12 - i10;
        int i14 = this.f21413k;
        if (i13 < i14) {
            try {
                String str2 = new String(this.f21410h, this.f21404b - i10, Math.min((i14 - i12) + i10, 20), A);
                sb2.append(", before: `");
                sb2.append(str2);
                sb2.append('`');
            } catch (Exception unused2) {
            }
        }
    }

    private int y() {
        int i10 = this.f21407e;
        int i11 = this.f21404b;
        int i12 = i10 - i11;
        byte[] bArr = this.f21410h;
        System.arraycopy(bArr, i11, bArr, 0, i12);
        int C = C(this.f21410h, this.f21412j, i12);
        long j10 = this.f21405c;
        int i13 = this.f21404b;
        this.f21405c = j10 + ((long) i13);
        if (C == i12) {
            int i14 = this.f21407e - i13;
            this.f21413k = i14;
            this.f21407e = i14;
            this.f21404b = 0;
        } else {
            int i15 = this.f21414l;
            if (C < i15) {
                i15 = C;
            }
            this.f21413k = i15;
            this.f21407e = C;
            this.f21404b = 0;
        }
        return C;
    }

    public final byte A() {
        if (this.f21412j != null && this.f21404b > this.f21413k) {
            y();
        }
        int i10 = this.f21404b;
        if (i10 < this.f21407e) {
            byte[] bArr = this.f21410h;
            this.f21404b = i10 + 1;
            byte b10 = bArr[i10];
            this.f21406d = b10;
            return b10;
        }
        throw o.a("Unexpected end of JSON input", B, N());
    }

    public final byte[] B() {
        if (this.f21412j != null && a.c(this.f21410h, this.f21404b) == this.f21410h.length) {
            int u10 = u();
            byte[] bArr = new byte[u10];
            for (int i10 = 0; i10 < u10; i10++) {
                bArr[i10] = (byte) this.f21411i[i10];
            }
            return a.a(bArr, 0, u10);
        } else if (this.f21406d == 34) {
            int i11 = this.f21404b;
            int c10 = a.c(this.f21410h, i11);
            byte[] bArr2 = this.f21410h;
            this.f21404b = c10 + 1;
            byte b10 = bArr2[c10];
            this.f21406d = b10;
            if (b10 == 34) {
                return a.a(bArr2, i11, c10);
            }
            throw n("Expecting '\"' for base64 end");
        } else {
            throw n("Expecting '\"' for base64 start");
        }
    }

    public final String D() {
        String str;
        int u10 = u();
        q qVar = this.f21415m;
        if (qVar != null) {
            str = qVar.a(this.f21411i, u10);
        } else {
            str = new String(this.f21411i, 0, u10);
        }
        if (h() == 58) {
            h();
            return str;
        }
        throw n("Expecting ':' after attribute name");
    }

    public final char[] E() {
        char[] cArr;
        if (this.f21406d == 34) {
            int i10 = this.f21404b;
            this.f21403a = i10;
            int i11 = 0;
            while (true) {
                try {
                    cArr = this.f21408f;
                    if (i11 >= cArr.length) {
                        break;
                    }
                    int i12 = i10 + 1;
                    byte b10 = this.f21410h[i10];
                    if (b10 == 34) {
                        i10 = i12;
                        break;
                    }
                    cArr[i11] = (char) b10;
                    i11++;
                    i10 = i12;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw p("JSON string was not closed with a double quote", 0);
                }
            }
            if (i10 <= this.f21407e) {
                this.f21404b = i10;
                return cArr;
            }
            throw p("JSON string was not closed with a double quote", 0);
        }
        throw n("Expecting '\"' for string start");
    }

    public final String F() {
        char[] cArr;
        if (this.f21406d == 34) {
            int i10 = this.f21404b;
            int i11 = 0;
            while (true) {
                try {
                    cArr = this.f21408f;
                    if (i11 >= cArr.length) {
                        break;
                    }
                    int i12 = i10 + 1;
                    byte b10 = this.f21410h[i10];
                    if (b10 == 34) {
                        i10 = i12;
                        break;
                    }
                    int i13 = i11 + 1;
                    cArr[i11] = (char) b10;
                    i11 = i13;
                    i10 = i12;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw p("JSON string was not closed with a double quote", 0);
                }
            }
            if (i10 <= this.f21407e) {
                this.f21404b = i10;
                return new String(cArr, 0, i11);
            }
            throw p("JSON string was not closed with a double quote", 0);
        }
        throw n("Expecting '\"' for string start");
    }

    public final String G() {
        int u10 = u();
        q qVar = this.f21416n;
        if (qVar == null) {
            return new String(this.f21411i, 0, u10);
        }
        return qVar.a(this.f21411i, u10);
    }

    /* access modifiers changed from: package-private */
    public final void H() {
        this.f21410h = this.f21418p;
        this.f21414l = this.f21419q;
        this.f21404b = 0;
        this.f21407e = 0;
        this.f21413k = 0;
        this.f21412j = null;
    }

    public final int I() {
        int i10 = this.f21404b;
        this.f21403a = i10 - 1;
        byte b10 = this.f21406d;
        int i11 = 1;
        while (i10 < this.f21407e) {
            int i12 = i10 + 1;
            b10 = this.f21410h[i10];
            if (b10 == 44 || b10 == 125 || b10 == 93) {
                break;
            }
            i11++;
            i10 = i12;
        }
        this.f21404b += i11 - 1;
        this.f21406d = b10;
        return this.f21403a;
    }

    public final boolean J() {
        if (this.f21406d != 102) {
            return false;
        }
        int i10 = this.f21404b;
        if (i10 + 3 < this.f21407e) {
            byte[] bArr = this.f21410h;
            if (bArr[i10] == 97 && bArr[i10 + 1] == 108 && bArr[i10 + 2] == 115 && bArr[i10 + 3] == 101) {
                this.f21404b = i10 + 4;
                this.f21406d = 101;
                return true;
            }
        }
        throw p("Invalid false constant found", 0);
    }

    public final boolean K() {
        if (this.f21406d != 110) {
            return false;
        }
        int i10 = this.f21404b;
        if (i10 + 2 < this.f21407e) {
            byte[] bArr = this.f21410h;
            if (bArr[i10] == 117 && bArr[i10 + 1] == 108 && bArr[i10 + 2] == 108) {
                this.f21404b = i10 + 3;
                this.f21406d = 108;
                return true;
            }
        }
        throw p("Invalid null constant found", 0);
    }

    public final boolean L() {
        if (this.f21406d != 116) {
            return false;
        }
        int i10 = this.f21404b;
        if (i10 + 2 < this.f21407e) {
            byte[] bArr = this.f21410h;
            if (bArr[i10] == 114 && bArr[i10 + 1] == 117 && bArr[i10 + 2] == 101) {
                this.f21404b = i10 + 3;
                this.f21406d = 101;
                return true;
            }
        }
        throw p("Invalid true constant found", 0);
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        if (this.f21420r == d.WITH_STACK_TRACE) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i10, int i11) {
        byte[] bArr = this.f21410h;
        while (i10 < i11) {
            if (!f21402z[bArr[i10] + 128]) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final StringBuffer b(StringBuffer stringBuffer) {
        stringBuffer.append(this.f21411i, 0, u());
        return stringBuffer;
    }

    public final StringBuilder c(StringBuilder sb2) {
        sb2.append(this.f21411i, 0, u());
        return sb2;
    }

    public final void d() {
        if (this.f21406d == 93) {
            return;
        }
        if (this.f21404b >= this.f21407e) {
            throw q("Unexpected end of JSON in collection", 0, B);
        }
        throw n("Expecting ']' as array end");
    }

    public final void e(f fVar, Collection collection) {
        if (K()) {
            collection.add((Object) null);
        } else {
            collection.add(fVar.a(this));
        }
        while (h() == 44) {
            h();
            if (K()) {
                collection.add((Object) null);
            } else {
                collection.add(fVar.a(this));
            }
        }
        d();
    }

    public final ArrayList f(f fVar) {
        ArrayList arrayList = new ArrayList(4);
        e(fVar, arrayList);
        return arrayList;
    }

    public final int g() {
        return this.f21404b;
    }

    public final byte h() {
        A();
        if (f21402z[this.f21406d + 128]) {
            while (M()) {
                A();
            }
        }
        return this.f21406d;
    }

    public final int i() {
        return this.f21403a;
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        if (this.f21412j == null) {
            if (this.f21407e == this.f21404b) {
                return true;
            }
            return false;
        } else if (this.f21407e != this.f21404b) {
            return false;
        } else {
            if (y() == 0) {
                return true;
            }
            return false;
        }
    }

    public final byte l() {
        return this.f21406d;
    }

    public final int m() {
        return this.f21407e;
    }

    public final o n(String str) {
        return o(str, 0);
    }

    public final o o(String str, int i10) {
        if (this.f21420r == d.MINIMAL) {
            return o.b(str, false);
        }
        this.f21426x.setLength(0);
        this.f21426x.append(str);
        this.f21426x.append(". Found ");
        this.f21426x.append((char) this.f21406d);
        if (this.f21420r == d.DESCRIPTION_ONLY) {
            return o.b(this.f21426x.toString(), false);
        }
        this.f21426x.append(" ");
        v(i10, this.f21426x);
        return o.b(this.f21426x.toString(), N());
    }

    public final o p(String str, int i10) {
        d dVar = this.f21420r;
        if (dVar == d.MINIMAL || dVar == d.DESCRIPTION_ONLY) {
            return o.b(str, false);
        }
        this.f21426x.setLength(0);
        this.f21426x.append(str);
        this.f21426x.append(" ");
        v(i10, this.f21426x);
        return o.b(this.f21426x.toString(), N());
    }

    public final o q(String str, int i10, Exception exc) {
        if (exc == null) {
            throw new IllegalArgumentException("cause can't be null");
        } else if (this.f21420r == d.MINIMAL) {
            return o.a(str, exc, false);
        } else {
            this.f21426x.setLength(0);
            String message = exc.getMessage();
            if (message != null && message.length() > 0) {
                this.f21426x.append(message);
                if (!message.endsWith(com.alibaba.pdns.f.G)) {
                    this.f21426x.append(com.alibaba.pdns.f.G);
                }
                this.f21426x.append(" ");
            }
            this.f21426x.append(str);
            if (this.f21420r == d.DESCRIPTION_ONLY) {
                return o.a(this.f21426x.toString(), exc, false);
            }
            this.f21426x.append(" ");
            v(i10, this.f21426x);
            return o.b(this.f21426x.toString(), N());
        }
    }

    public final o r(String str, int i10, String str2, Object... objArr) {
        if (this.f21420r == d.MINIMAL) {
            return o.b(str, false);
        }
        this.f21426x.setLength(0);
        this.f21427y.format(str2, objArr);
        if (this.f21420r == d.DESCRIPTION_ONLY) {
            return o.b(this.f21426x.toString(), false);
        }
        this.f21426x.append(" ");
        v(i10, this.f21426x);
        return o.b(this.f21426x.toString(), N());
    }

    public final o s(String str, int i10, String str2, String str3, Object obj, String str4) {
        if (this.f21420r == d.MINIMAL) {
            return o.b(str, false);
        }
        this.f21426x.setLength(0);
        this.f21426x.append(str2);
        this.f21426x.append(str3);
        if (obj != null) {
            this.f21426x.append(": '");
            this.f21426x.append(obj.toString());
            this.f21426x.append("'");
        }
        this.f21426x.append(str4);
        if (this.f21420r == d.DESCRIPTION_ONLY) {
            return o.b(this.f21426x.toString(), false);
        }
        this.f21426x.append(" ");
        v(i10, this.f21426x);
        return o.b(this.f21426x.toString(), N());
    }

    public final o t(String str, Object obj) {
        return s(str, 0, "", str, obj, "");
    }

    public String toString() {
        return new String(this.f21410h, 0, this.f21407e, A);
    }

    /* access modifiers changed from: package-private */
    public final int u() {
        int i10;
        int i11;
        int i12 = this.f21404b;
        if (this.f21406d == 34) {
            int i13 = this.f21407e;
            if (i12 != i13) {
                char[] cArr = this.f21411i;
                int i14 = i13 - i12;
                if (cArr.length < i14) {
                    i14 = cArr.length;
                }
                int i15 = i12;
                int i16 = 0;
                while (true) {
                    if (i16 >= i14) {
                        break;
                    }
                    int i17 = i15 + 1;
                    byte b10 = this.f21410h[i15];
                    if (b10 == 34) {
                        this.f21404b = i17;
                        return i16;
                    } else if ((b10 ^ 92) < 1) {
                        i15 = i17;
                        break;
                    } else {
                        cArr[i16] = (char) b10;
                        i16++;
                        i15 = i17;
                    }
                }
                if (i16 == cArr.length) {
                    char[] cArr2 = this.f21411i;
                    int length = cArr2.length * 2;
                    int i18 = this.f21425w;
                    if (length <= i18) {
                        cArr = Arrays.copyOf(cArr2, length);
                        this.f21411i = cArr;
                    } else {
                        throw t("Maximum string buffer limit exceeded", Integer.valueOf(i18));
                    }
                }
                int length2 = cArr.length;
                int i19 = i15 - 1;
                this.f21404b = i19;
                int i20 = i19 - i12;
                while (!k()) {
                    int A2 = A();
                    if (A2 == 34) {
                        return i20;
                    }
                    if (A2 == 92) {
                        if (i20 >= length2 - 6) {
                            char[] cArr3 = this.f21411i;
                            int length3 = cArr3.length * 2;
                            int i21 = this.f21425w;
                            if (length3 <= i21) {
                                cArr = Arrays.copyOf(cArr3, length3);
                                this.f21411i = cArr;
                                length2 = cArr.length;
                            } else {
                                throw t("Maximum string buffer limit exceeded", Integer.valueOf(i21));
                            }
                        }
                        byte[] bArr = this.f21410h;
                        int i22 = this.f21404b;
                        int i23 = i22 + 1;
                        this.f21404b = i23;
                        byte b11 = bArr[i22];
                        if (b11 == 34 || b11 == 47 || b11 == 92) {
                            A2 = b11;
                            cArr[i20] = (char) A2;
                            i20++;
                        } else {
                            if (b11 == 98) {
                                A2 = 8;
                            } else if (b11 == 102) {
                                A2 = 12;
                            } else if (b11 == 110) {
                                A2 = 10;
                            } else if (b11 == 114) {
                                A2 = 13;
                            } else if (b11 == 116) {
                                A2 = 9;
                            } else if (b11 == 117) {
                                this.f21404b = i22 + 2;
                                byte[] bArr2 = this.f21410h;
                                int i24 = this.f21404b;
                                this.f21404b = i24 + 1;
                                int j10 = (j(bArr[i23]) << 12) + (j(bArr2[i24]) << 8);
                                byte[] bArr3 = this.f21410h;
                                int i25 = this.f21404b;
                                this.f21404b = i25 + 1;
                                i10 = j10 + (j(bArr3[i25]) << 4);
                                byte[] bArr4 = this.f21410h;
                                int i26 = this.f21404b;
                                this.f21404b = i26 + 1;
                                i11 = j(bArr4[i26]);
                            } else {
                                throw t("Invalid escape combination detected", Integer.valueOf(b11));
                            }
                            cArr[i20] = (char) A2;
                            i20++;
                        }
                    } else {
                        if ((A2 & 128) != 0) {
                            if (i20 >= length2 - 4) {
                                char[] cArr4 = this.f21411i;
                                int length4 = cArr4.length * 2;
                                int i27 = this.f21425w;
                                if (length4 <= i27) {
                                    char[] copyOf = Arrays.copyOf(cArr4, length4);
                                    this.f21411i = copyOf;
                                    cArr = copyOf;
                                    length2 = copyOf.length;
                                } else {
                                    throw t("Maximum string buffer limit exceeded", Integer.valueOf(i27));
                                }
                            }
                            byte[] bArr5 = this.f21410h;
                            int i28 = this.f21404b;
                            int i29 = i28 + 1;
                            this.f21404b = i29;
                            byte b12 = bArr5[i28];
                            if ((A2 & 224) == 192) {
                                i10 = (A2 & 31) << 6;
                                i11 = b12 & Utf8.REPLACEMENT_BYTE;
                            } else {
                                int i30 = i28 + 2;
                                this.f21404b = i30;
                                byte b13 = bArr5[i29];
                                if ((A2 & 240) == 224) {
                                    i10 = ((A2 & 15) << 12) + ((b12 & Utf8.REPLACEMENT_BYTE) << 6);
                                    i11 = b13 & Utf8.REPLACEMENT_BYTE;
                                } else {
                                    this.f21404b = i28 + 3;
                                    byte b14 = bArr5[i30];
                                    if ((A2 & 248) == 240) {
                                        A2 = ((A2 & 7) << 18) + ((b12 & Utf8.REPLACEMENT_BYTE) << 12) + ((b13 & Utf8.REPLACEMENT_BYTE) << 6) + (b14 & Utf8.REPLACEMENT_BYTE);
                                        if (A2 >= 65536) {
                                            if (A2 < 1114112) {
                                                int i31 = A2 - 65536;
                                                int i32 = i20 + 1;
                                                cArr[i20] = (char) ((i31 >>> 10) + 55296);
                                                i20 += 2;
                                                cArr[i32] = (char) ((i31 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                            } else {
                                                throw p("Invalid unicode character detected", 0);
                                            }
                                        }
                                    } else {
                                        throw p("Invalid unicode character detected", 0);
                                    }
                                }
                            }
                        } else if (i20 >= length2) {
                            char[] cArr5 = this.f21411i;
                            int length5 = cArr5.length * 2;
                            int i33 = this.f21425w;
                            if (length5 <= i33) {
                                char[] copyOf2 = Arrays.copyOf(cArr5, length5);
                                this.f21411i = copyOf2;
                                cArr = copyOf2;
                                length2 = copyOf2.length;
                            } else {
                                throw t("Maximum string buffer limit exceeded", Integer.valueOf(i33));
                            }
                        }
                        cArr[i20] = (char) A2;
                        i20++;
                    }
                    A2 = i10 + i11;
                    cArr[i20] = (char) A2;
                    i20++;
                }
                throw p("JSON string was not closed with a double quote", 0);
            }
            throw p("Premature end of JSON string", 0);
        }
        throw n("Expecting '\"' for string start");
    }

    public final long w(int i10) {
        return (this.f21405c + ((long) this.f21404b)) - ((long) i10);
    }

    /* access modifiers changed from: package-private */
    public final char[] x(int i10, int i11) {
        char[] cArr;
        if (i11 <= this.f21424v) {
            while (true) {
                cArr = this.f21411i;
                if (cArr.length >= i11) {
                    break;
                }
                this.f21411i = Arrays.copyOf(cArr, cArr.length * 2);
            }
            byte[] bArr = this.f21410h;
            for (int i12 = 0; i12 < i11; i12++) {
                cArr[i12] = (char) bArr[i10 + i12];
            }
            return cArr;
        }
        throw s("Too many digits detected in number", i11, "", "Too many digits detected in number", Integer.valueOf(i11), "");
    }

    public final j z(InputStream inputStream) {
        this.f21405c = 0;
        this.f21404b = 0;
        this.f21412j = inputStream;
        if (inputStream != null) {
            int i10 = this.f21407e;
            int i11 = this.f21414l;
            if (i10 >= i11) {
                i10 = i11;
            }
            this.f21413k = i10;
            int C = C(this.f21410h, inputStream, 0);
            int i12 = this.f21414l;
            if (C < i12) {
                i12 = C;
            }
            this.f21413k = i12;
            this.f21407e = C;
        }
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    j(byte[] bArr, int i10, Object obj, char[] cArr, q qVar, q qVar2, s sVar, d dVar, b bVar, g gVar, int i11, int i12) {
        this(cArr, bArr, i10, obj, qVar, qVar2, sVar, dVar, bVar, gVar, i11, i12);
        byte[] bArr2 = bArr;
        int i13 = i10;
        if (cArr == null) {
            throw new IllegalArgumentException("tmp buffer provided as null.");
        } else if (i13 > bArr2.length) {
            throw new IllegalArgumentException("length can't be longer than buffer.length");
        } else if (i13 < bArr2.length) {
            bArr2[i13] = 0;
        }
    }
}
