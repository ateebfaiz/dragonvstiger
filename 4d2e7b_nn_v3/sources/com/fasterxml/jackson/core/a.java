package com.fasterxml.jackson.core;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final transient int[] f5058a;

    /* renamed from: b  reason: collision with root package name */
    private final transient char[] f5059b;

    /* renamed from: c  reason: collision with root package name */
    private final transient byte[] f5060c;

    /* renamed from: d  reason: collision with root package name */
    final String f5061d;

    /* renamed from: e  reason: collision with root package name */
    private final char f5062e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5063f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5064g;

    /* renamed from: h  reason: collision with root package name */
    private final C0068a f5065h;

    /* renamed from: com.fasterxml.jackson.core.a$a  reason: collision with other inner class name */
    public enum C0068a {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public a(String str, String str2, boolean z10, char c10, int i10) {
        int[] iArr = new int[128];
        this.f5058a = iArr;
        char[] cArr = new char[64];
        this.f5059b = cArr;
        this.f5060c = new byte[64];
        this.f5061d = str;
        this.f5064g = z10;
        this.f5062e = c10;
        this.f5063f = i10;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, cArr, 0);
            Arrays.fill(iArr, -1);
            for (int i11 = 0; i11 < length; i11++) {
                char c11 = this.f5059b[i11];
                this.f5060c[i11] = (byte) c11;
                this.f5058a[c11] = i11;
            }
            if (z10) {
                this.f5058a[c10] = -2;
            }
            this.f5065h = z10 ? C0068a.PADDING_REQUIRED : C0068a.PADDING_FORBIDDEN;
            return;
        }
        throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
    }

    public String a(byte[] bArr) {
        return b(bArr, false);
    }

    public String b(byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z10) {
            sb2.append('\"');
        }
        int h10 = h() >> 2;
        int i10 = length - 3;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = i11 + 2;
            byte b10 = bArr[i11 + 1] & 255;
            i11 += 3;
            d(sb2, ((b10 | (bArr[i11] << 8)) << 8) | (bArr[i12] & 255));
            h10--;
            if (h10 <= 0) {
                sb2.append('\\');
                sb2.append('n');
                h10 = h() >> 2;
            }
        }
        int i13 = length - i11;
        if (i13 > 0) {
            int i14 = i11 + 1;
            int i15 = bArr[i11] << 16;
            if (i13 == 2) {
                i15 |= (bArr[i14] & 255) << 8;
            }
            f(sb2, i15, i13);
        }
        if (z10) {
            sb2.append('\"');
        }
        return sb2.toString();
    }

    public int c(int i10, char[] cArr, int i11) {
        char[] cArr2 = this.f5059b;
        cArr[i11] = cArr2[(i10 >> 18) & 63];
        cArr[i11 + 1] = cArr2[(i10 >> 12) & 63];
        int i12 = i11 + 3;
        cArr[i11 + 2] = cArr2[(i10 >> 6) & 63];
        int i13 = i11 + 4;
        cArr[i12] = cArr2[i10 & 63];
        return i13;
    }

    public void d(StringBuilder sb2, int i10) {
        sb2.append(this.f5059b[(i10 >> 18) & 63]);
        sb2.append(this.f5059b[(i10 >> 12) & 63]);
        sb2.append(this.f5059b[(i10 >> 6) & 63]);
        sb2.append(this.f5059b[i10 & 63]);
    }

    public int e(int i10, int i11, char[] cArr, int i12) {
        char c10;
        char[] cArr2 = this.f5059b;
        cArr[i12] = cArr2[(i10 >> 18) & 63];
        int i13 = i12 + 2;
        cArr[i12 + 1] = cArr2[(i10 >> 12) & 63];
        if (i()) {
            int i14 = i12 + 3;
            if (i11 == 2) {
                c10 = this.f5059b[(i10 >> 6) & 63];
            } else {
                c10 = this.f5062e;
            }
            cArr[i13] = c10;
            int i15 = i12 + 4;
            cArr[i14] = this.f5062e;
            return i15;
        } else if (i11 != 2) {
            return i13;
        } else {
            cArr[i13] = this.f5059b[(i10 >> 6) & 63];
            return i12 + 3;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f5062e == this.f5062e && aVar.f5063f == this.f5063f && aVar.f5064g == this.f5064g && aVar.f5065h == this.f5065h && this.f5061d.equals(aVar.f5061d)) {
            return true;
        }
        return false;
    }

    public void f(StringBuilder sb2, int i10, int i11) {
        char c10;
        sb2.append(this.f5059b[(i10 >> 18) & 63]);
        sb2.append(this.f5059b[(i10 >> 12) & 63]);
        if (i()) {
            if (i11 == 2) {
                c10 = this.f5059b[(i10 >> 6) & 63];
            } else {
                c10 = this.f5062e;
            }
            sb2.append(c10);
            sb2.append(this.f5062e);
        } else if (i11 == 2) {
            sb2.append(this.f5059b[(i10 >> 6) & 63]);
        }
    }

    public int h() {
        return this.f5063f;
    }

    public int hashCode() {
        return this.f5061d.hashCode();
    }

    public boolean i() {
        return this.f5064g;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        a b10 = b.b(this.f5061d);
        boolean z10 = this.f5064g;
        boolean z11 = b10.f5064g;
        if (z10 == z11 && this.f5062e == b10.f5062e && this.f5065h == b10.f5065h && this.f5063f == b10.f5063f && z10 == z11) {
            return b10;
        }
        return new a(b10, this.f5061d, z10, this.f5062e, this.f5065h, this.f5063f);
    }

    public String toString() {
        return this.f5061d;
    }

    public a(a aVar, String str, int i10) {
        this(aVar, str, aVar.f5064g, aVar.f5062e, i10);
    }

    public a(a aVar, String str, boolean z10, char c10, int i10) {
        this(aVar, str, z10, c10, aVar.f5065h, i10);
    }

    private a(a aVar, String str, boolean z10, char c10, C0068a aVar2, int i10) {
        int[] iArr = new int[128];
        this.f5058a = iArr;
        char[] cArr = new char[64];
        this.f5059b = cArr;
        byte[] bArr = new byte[64];
        this.f5060c = bArr;
        this.f5061d = str;
        byte[] bArr2 = aVar.f5060c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = aVar.f5059b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = aVar.f5058a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f5064g = z10;
        this.f5062e = c10;
        this.f5063f = i10;
        this.f5065h = aVar2;
    }
}
