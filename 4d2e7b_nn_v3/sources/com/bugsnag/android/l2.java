package com.bugsnag.android;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

abstract class l2 implements Closeable, Flushable {

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f18821j = new String[128];

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f18822w;

    /* renamed from: a  reason: collision with root package name */
    private final Writer f18823a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f18824b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f18825c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f18826d;

    /* renamed from: e  reason: collision with root package name */
    private String f18827e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18828f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18829g;

    /* renamed from: h  reason: collision with root package name */
    private String f18830h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18831i;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f18821j[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f18821j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f18822w = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public l2(Writer writer) {
        B(6);
        this.f18827e = ":";
        this.f18831i = true;
        if (writer != null) {
            this.f18823a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private int A() {
        int i10 = this.f18825c;
        if (i10 != 0) {
            return this.f18824b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void B(int i10) {
        int i11 = this.f18825c;
        int[] iArr = this.f18824b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(i11 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f18824b = iArr2;
        }
        int[] iArr3 = this.f18824b;
        int i12 = this.f18825c;
        this.f18825c = i12 + 1;
        iArr3[i12] = i10;
    }

    private void C(int i10) {
        this.f18824b[this.f18825c - 1] = i10;
    }

    private void G(String str) {
        String[] strArr;
        String str2;
        if (this.f18829g) {
            strArr = f18822w;
        } else {
            strArr = f18821j;
        }
        this.f18823a.write("\"");
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
                this.f18823a.write(str, i10, i11 - i10);
            }
            this.f18823a.write(str2);
            i10 = i11 + 1;
        }
        if (i10 < length) {
            this.f18823a.write(str, i10, length - i10);
        }
        this.f18823a.write("\"");
    }

    private void M() {
        if (this.f18830h != null) {
            a();
            G(this.f18830h);
            this.f18830h = null;
        }
    }

    private void a() {
        int A = A();
        if (A == 5) {
            this.f18823a.write(44);
        } else if (A != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        w();
        C(4);
    }

    private l2 k(int i10, int i11, String str) {
        int A = A();
        if (A != i11 && A != i10) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f18830h == null) {
            this.f18825c--;
            if (A == i11) {
                w();
            }
            this.f18823a.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f18830h);
        }
    }

    private void w() {
        if (this.f18826d != null) {
            this.f18823a.write("\n");
            int i10 = this.f18825c;
            for (int i11 = 1; i11 < i10; i11++) {
                this.f18823a.write(this.f18826d);
            }
        }
    }

    private l2 z(int i10, String str) {
        b();
        B(i10);
        this.f18823a.write(str);
        return this;
    }

    public final void E(boolean z10) {
        this.f18831i = z10;
    }

    public l2 H(long j10) {
        M();
        b();
        this.f18823a.write(Long.toString(j10));
        return this;
    }

    public l2 I(Boolean bool) {
        String str;
        if (bool == null) {
            return y();
        }
        M();
        b();
        Writer writer = this.f18823a;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public l2 J(Number number) {
        if (number == null) {
            return y();
        }
        String obj = number.toString();
        if (this.f18828f || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            M();
            b();
            this.f18823a.write(obj);
        } else {
            this.f18830h = null;
        }
        return this;
    }

    public l2 K(String str) {
        if (str == null) {
            return y();
        }
        M();
        b();
        G(str);
        return this;
    }

    public l2 L(boolean z10) {
        String str;
        M();
        b();
        Writer writer = this.f18823a;
        if (z10) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int A = A();
        if (A == 1) {
            C(2);
            w();
        } else if (A == 2) {
            this.f18823a.write(44);
            w();
        } else if (A != 4) {
            if (A != 6) {
                if (A != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f18828f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            C(7);
        } else {
            this.f18823a.write(this.f18827e);
            C(5);
        }
    }

    public void close() {
        this.f18823a.close();
        int i10 = this.f18825c;
        if (i10 > 1 || (i10 == 1 && this.f18824b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f18825c = 0;
    }

    public void flush() {
        if (this.f18825c != 0) {
            this.f18823a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public l2 h() {
        M();
        return z(1, "[");
    }

    public l2 j() {
        M();
        return z(3, "{");
    }

    public l2 m() {
        return k(1, 2, "]");
    }

    public l2 n() {
        return k(3, 5, "}");
    }

    public final boolean p() {
        return this.f18831i;
    }

    public l2 v(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f18830h != null) {
            throw new IllegalStateException();
        } else if (this.f18825c != 0) {
            this.f18830h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public l2 y() {
        if (this.f18830h != null) {
            if (this.f18831i) {
                M();
            } else {
                this.f18830h = null;
                return this;
            }
        }
        b();
        this.f18823a.write("null");
        return this;
    }
}
