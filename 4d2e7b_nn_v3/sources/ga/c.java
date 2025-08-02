package ga;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class c implements Closeable, Flushable {
    private static final String[] C;

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f12257j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f12258w = new String[128];

    /* renamed from: a  reason: collision with root package name */
    private final Writer f12259a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f12260b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f12261c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f12262d;

    /* renamed from: e  reason: collision with root package name */
    private String f12263e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12264f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12265g;

    /* renamed from: h  reason: collision with root package name */
    private String f12266h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12267i;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f12258w[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f12258w;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        C = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        G(6);
        this.f12263e = ":";
        this.f12267i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f12259a = writer;
    }

    private void A() {
        if (this.f12262d != null) {
            this.f12259a.write(10);
            int i10 = this.f12261c;
            for (int i11 = 1; i11 < i10; i11++) {
                this.f12259a.write(this.f12262d);
            }
        }
    }

    private c C(int i10, char c10) {
        b();
        G(i10);
        this.f12259a.write(c10);
        return this;
    }

    private int E() {
        int i10 = this.f12261c;
        if (i10 != 0) {
            return this.f12260b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void G(int i10) {
        int i11 = this.f12261c;
        int[] iArr = this.f12260b;
        if (i11 == iArr.length) {
            this.f12260b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f12260b;
        int i12 = this.f12261c;
        this.f12261c = i12 + 1;
        iArr2[i12] = i10;
    }

    private void H(int i10) {
        this.f12260b[this.f12261c - 1] = i10;
    }

    private void M(String str) {
        String[] strArr;
        String str2;
        if (this.f12265g) {
            strArr = C;
        } else {
            strArr = f12258w;
        }
        this.f12259a.write(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i10 < i11) {
                this.f12259a.write(str, i10, i11 - i10);
            }
            this.f12259a.write(str2);
            i10 = i11 + 1;
        }
        if (i10 < length) {
            this.f12259a.write(str, i10, length - i10);
        }
        this.f12259a.write(34);
    }

    private void T() {
        if (this.f12266h != null) {
            a();
            M(this.f12266h);
            this.f12266h = null;
        }
    }

    private void a() {
        int E = E();
        if (E == 5) {
            this.f12259a.write(44);
        } else if (E != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        A();
        H(4);
    }

    private void b() {
        int E = E();
        if (E == 1) {
            H(2);
            A();
        } else if (E == 2) {
            this.f12259a.append(',');
            A();
        } else if (E != 4) {
            if (E != 6) {
                if (E != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f12264f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            H(7);
        } else {
            this.f12259a.append(this.f12263e);
            H(5);
        }
    }

    private c k(int i10, int i11, char c10) {
        int E = E();
        if (E != i11 && E != i10) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f12266h == null) {
            this.f12261c--;
            if (E == i11) {
                A();
            }
            this.f12259a.write(c10);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f12266h);
        }
    }

    private static boolean y(Class cls) {
        if (cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class) {
            return true;
        }
        return false;
    }

    public c B() {
        if (this.f12266h != null) {
            if (this.f12267i) {
                T();
            } else {
                this.f12266h = null;
                return this;
            }
        }
        b();
        this.f12259a.write("null");
        return this;
    }

    public final void I(boolean z10) {
        this.f12265g = z10;
    }

    public final void J(String str) {
        if (str.length() == 0) {
            this.f12262d = null;
            this.f12263e = ":";
            return;
        }
        this.f12262d = str;
        this.f12263e = ": ";
    }

    public final void K(boolean z10) {
        this.f12264f = z10;
    }

    public final void L(boolean z10) {
        this.f12267i = z10;
    }

    public c N(double d10) {
        T();
        if (this.f12264f || (!Double.isNaN(d10) && !Double.isInfinite(d10))) {
            b();
            this.f12259a.append(Double.toString(d10));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
    }

    public c O(long j10) {
        T();
        b();
        this.f12259a.write(Long.toString(j10));
        return this;
    }

    public c P(Boolean bool) {
        String str;
        if (bool == null) {
            return B();
        }
        T();
        b();
        Writer writer = this.f12259a;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public c Q(Number number) {
        if (number == null) {
            return B();
        }
        T();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!y(cls) && !f12257j.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f12264f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        b();
        this.f12259a.append(obj);
        return this;
    }

    public c R(String str) {
        if (str == null) {
            return B();
        }
        T();
        b();
        M(str);
        return this;
    }

    public c S(boolean z10) {
        String str;
        T();
        b();
        Writer writer = this.f12259a;
        if (z10) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public void close() {
        this.f12259a.close();
        int i10 = this.f12261c;
        if (i10 > 1 || (i10 == 1 && this.f12260b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f12261c = 0;
    }

    public void flush() {
        if (this.f12261c != 0) {
            this.f12259a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c h() {
        T();
        return C(1, '[');
    }

    public c j() {
        T();
        return C(3, '{');
    }

    public c m() {
        return k(1, 2, ']');
    }

    public c n() {
        return k(3, 5, '}');
    }

    public final boolean p() {
        return this.f12267i;
    }

    public final boolean v() {
        return this.f12265g;
    }

    public boolean w() {
        return this.f12264f;
    }

    public c z(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f12266h != null) {
            throw new IllegalStateException();
        } else if (this.f12261c != 0) {
            this.f12266h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }
}
